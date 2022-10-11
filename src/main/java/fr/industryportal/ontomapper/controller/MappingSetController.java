package fr.industryportal.ontomapper.controller;

import fr.industryportal.ontomapper.cache.CacheSet;
import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
