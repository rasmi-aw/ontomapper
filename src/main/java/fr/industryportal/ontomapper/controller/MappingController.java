package fr.industryportal.ontomapper.controller;


import fr.industryportal.ontomapper.cache.CacheMapping;
import fr.industryportal.ontomapper.model.entities.Mapping;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Controller to manage mappings
 */
@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    private MappingRepository mappingRepository;

    /**
     * get a list of mappings for a specefic set
     */
    @GetMapping("")
    public List<Mapping> getFiftyMappings(@RequestParam Long set_id, @RequestParam Long from) {
        return CacheMapping.getInstance(mappingRepository).get(set_id, from);
    }
}
