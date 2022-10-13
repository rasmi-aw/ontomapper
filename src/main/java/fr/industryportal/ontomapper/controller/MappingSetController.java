package fr.industryportal.ontomapper.controller;

import fr.industryportal.ontomapper.cache.CacheSet;
import fr.industryportal.ontomapper.model.entities.Contribution;
import fr.industryportal.ontomapper.model.entities.Contributor;
import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.entities.enums.ContributorType;
import fr.industryportal.ontomapper.model.repos.ContributionRepository;
import fr.industryportal.ontomapper.model.repos.ContributorRepository;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
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
    private MappingRepository mappingRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private ContributionRepository contributionRepository;


    @GetMapping("")
    public List<MappingSet> getAllSets() {
        return CacheSet.getInstance(mappingSetRepository).getSets();
    }

    @GetMapping("/match")
    public List<MappingSet> getSetsByStringMatch(@RequestParam String string) {
        System.out.println(string);
        string = string.toLowerCase().trim();
        String finalMatch = string;

        return CacheSet
                .getInstance(mappingSetRepository)
                .getSets()
                .stream()
                .filter(ms ->
                        ms.getMapping_set_id().toLowerCase().contains(finalMatch)
                                || ms.getVersion().toLowerCase().contains(finalMatch)
                                || ms.getDescription().toLowerCase().contains(finalMatch)
                                || ms.getLicense().toLowerCase().contains(finalMatch)
                                || ms.getSubject_type().getValue().toLowerCase().contains(finalMatch)
                                || ms.getSubject_source().toLowerCase().contains(finalMatch)
                                || ms.getSubject_source_version().toLowerCase().contains(finalMatch)
                                || ms.getObject_type().getValue().toLowerCase().contains(finalMatch)
                                || ms.getObject_source().toLowerCase().contains(finalMatch)
                                || ms.getObject_source_version().toLowerCase().contains(finalMatch)
                                || ms.getMapping_provider().toLowerCase().contains(finalMatch)
                                || ms.getMapping_tool().toLowerCase().contains(finalMatch)
                                || ms.getSubject_match_field().toLowerCase().contains(finalMatch)
                                || ms.getObject_match_field().toLowerCase().contains(finalMatch)
                                || ms.getObject_preprocessing().toLowerCase().contains(finalMatch)
                                || ms.getSubject_preprocessing().toLowerCase().contains(finalMatch)
                                || ms.getSee_also().toLowerCase().contains(finalMatch)
                                || ms.getOther().toLowerCase().contains(finalMatch)
                                || ms.getComment().toLowerCase().contains(finalMatch))
                .collect(Collectors.toList());
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
            if (s == null || !s.isDeleted()) {
                if (s != null)
                    setRequest.setId(s.getId());
                s = mappingSetRepository.save(setRequest.toDBModel(mappingSetRepository));
            }
            //saving creators (as contributors) if they don't exist
            MappingSet finalS = s;
            setRequest.getCreators().forEach(c -> {
                Contributor creator;
                try {
                    creator = contributorRepository.save(c.toDBModel(null));
                } catch (Exception e) {
                    creator = contributorRepository.findByContributorId(c.getId());
                }
                //
                if (finalS != null) {
                    List<MappingSet> mappingSets = Stream.of(finalS).collect(Collectors.toList());
                    contributionRepository.save(new Contribution(null, creator, ContributorType.CREATOR, mappingSets, null, false));
                }
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
        sets.forEach(set -> {
            mappingRepository.deleteBySetId(set);
            mappingSetRepository.deleteById(set);
        });
        //
        CacheSet
                .getInstance(mappingSetRepository)
                .rearm();
    }

}
