package fr.industryportal.ontomapper.controller;

import fr.industryportal.ontomapper.cache.CacheSet;
import fr.industryportal.ontomapper.model.entities.Contribution;
import fr.industryportal.ontomapper.model.entities.Contributor;
import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.entities.enums.ContributorType;
import fr.industryportal.ontomapper.model.repos.ContributionRepository;
import fr.industryportal.ontomapper.model.repos.ContributorRepository;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import fr.industryportal.ontomapper.model.requests.SetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Abdelwadoud Rasmi
 * Controller to manage mapping sets
 */
@RestController
@RequestMapping("/set")
public class MappingSetController {

    @Autowired
    private MappingSetRepository mappingSetRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private ContributionRepository contributionRepository;


    @GetMapping("")
    public List<MappingSet> getAllSets() {
        return CacheSet.getInstance(mappingSetRepository).getSets();
    }


    /**
     * Add or delete a list of mappingSets
     */
    @PostMapping("")
    public void addOrEditMappingSets(@RequestBody List<SetRequest> sets) {
        //
        sets.forEach(setRequest -> {
            MappingSet s = setRequest.toDBModel(mappingSetRepository);
            // inserting or updating the mapping set
            s = mappingSetRepository.findByStringId(s.getMapping_set_id());
            if (s == null)
                s = mappingSetRepository.save(setRequest.toDBModel(mappingSetRepository));
            //saving creators (as contributors) if they don't exist
            MappingSet finalS = s;
            setRequest.getCreators().forEach(c -> {
                Contributor creator;
                try {
                    creator = contributorRepository.save(c.toDBModel(null));
                } catch (Exception e) {
                    creator = contributorRepository.findByContributorId(c.getId());
                }
                List<MappingSet> mappingSets = Stream.of(finalS).collect(Collectors.toList());
                contributionRepository.save(new Contribution(null, creator, ContributorType.CREATOR, mappingSets, null, false));
            });
        });
        //
        CacheSet
                .getInstance(mappingSetRepository)
                .rearm();
    }


    /**
     * Delete a mapping set along with its mappings
     */
    @DeleteMapping("")
    public void deleteSets(@RequestBody List<Long> sets) {

    }

}
