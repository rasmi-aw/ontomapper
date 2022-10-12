package fr.industryportal.ontomapper.cache;

import fr.industryportal.ontomapper.model.entities.Mapping;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author Abdelwadoud Rasmi
 * Cached mappings
 */
public class CacheMapping {
    private static CacheMapping instance;
    private MappingRepository mappingRepository;
    @Getter
    private HashMap<String, Mapping> mappings;

    /**
     *
     */
    public static CacheMapping getInstance(MappingRepository mappingRepository) {
        if (instance == null)
            instance = new CacheMapping(mappingRepository);
        return instance;
    }

    /**
     * Private constructor
     */
    private CacheMapping(MappingRepository mappingRepository) {
        this.mappingRepository = mappingRepository;
    }

    /**
     *
     */
    public CacheMapping unify() {
        mappings.clear();
        mappings = new HashMap<>();
        return this;
    }

}
