package fr.industryportal.ontomapper.controller;


import fr.industryportal.ontomapper.cache.CacheMapping;
import fr.industryportal.ontomapper.cache.CacheSet;
import fr.industryportal.ontomapper.model.entities.Contribution;
import fr.industryportal.ontomapper.model.entities.Contributor;
import fr.industryportal.ontomapper.model.entities.Mapping;
import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.entities.enums.ContributorType;
import fr.industryportal.ontomapper.model.repos.ContributionRepository;
import fr.industryportal.ontomapper.model.repos.ContributorRepository;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import fr.industryportal.ontomapper.model.requests.MappingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Abdelwadoud Rasmi
 * Controller to manage mappings
 */
@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    private MappingRepository mappingRepository;

    @Autowired
    private MappingSetRepository mappingSetRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private ContributionRepository contributionRepository;

    /**
     * get a list of mappings for a specific set
     */
    @GetMapping("")
    public List<Mapping> getFiftyMappings(@RequestParam Long set_id, @RequestParam Long from) {
        MappingSet mappingSet = new MappingSet();
        mappingSet.setId(set_id);
        //
        if (mappingSet.getSource().isEmpty())
            return CacheMapping.getInstance(mappingRepository).get(set_id, from);
        else {
            List<Mapping> mappings = new ArrayList<>();
            mappingSet.getSource().forEach(ms -> mappings.addAll(CacheMapping.getInstance(mappingRepository).get(ms.getId(), from)));
            return mappings;
        }
    }

    /**
     * Add or delete a list of mappings
     */
    @PostMapping("")
    public void addOrEditListOfMappings(@RequestBody List<MappingRequest> mappings) {
        //
        List<Mapping> saved = new ArrayList<>();
        mappings.forEach(mapping -> {
            Mapping m = mapping.toDBModel(mappingSetRepository);
            // inserting or updating the mapping
            m = mappingRepository.findByStringId(m.getMapping_id());
            if (m == null || !m.isDeleted()) {
                if (m != null)
                    mapping.setId(m.getId());
                // checking if the set has sources, if true then don't insert the mapping and skip tgis iteration
                if (m.getSet().getSource().isEmpty()) {
                    m = mappingRepository.save(mapping.toDBModel(mappingSetRepository));
                    saved.add(m);
                } else
                    m = null;
            }
            //saving contributors if they don't exist and if the mapping was saved in the previous step
            if (m != null) {
                Mapping finalM = m;
                if (mapping.getContributors() != null)
                    mapping.getContributors().forEach(c -> {
                        Contributor contributor;
                        try {
                            contributor = contributorRepository.save(c.toDBModel(null));
                        } catch (Exception e) {
                            contributor = contributorRepository.findByContributorId(c.getId());
                        }

                        //
                        if (finalM != null) {
                            List<Mapping> mappings1 = Stream.of(finalM).collect(Collectors.toList());
                            contributionRepository.save(new Contribution(null, contributor, c.getType(), null, mappings1, false));
                        }
                    });
            }
        });
        // Update cache
        CacheMapping
                .getInstance(mappingRepository)
                .update(saved);
    }
}