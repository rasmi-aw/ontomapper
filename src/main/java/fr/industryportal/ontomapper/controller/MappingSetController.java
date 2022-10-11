package fr.industryportal.ontomapper.controller;

import fr.industryportal.ontomapper.cache.CacheSet;
import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import fr.industryportal.ontomapper.model.requests.SetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Abdelwadoud Rasmi
 * Controller to manage mapping sets
 */
@RestController
@RequestMapping("/set")
public class MappingSetController {

    @Autowired
    private MappingSetRepository mappingSetRepository;

    @GetMapping("")
    public List<MappingSet> getAllSets() {
        return CacheSet.getInstance(mappingSetRepository).getSets();
    }

    @PostMapping("")
    public void addOrEditMappingSets(@RequestBody List<SetRequest> sets) {
        List<MappingSet> storedSets = CacheSet.getInstance(mappingSetRepository).getSets();
        //
        sets.stream().forEach(setRequest -> {
            MappingSet storedSet = storedSets.get(storedSets.indexOf(setRequest.toDBModel(null)));
        });
    }

}
