package fr.industryportal.ontomapper.cache;

import fr.industryportal.ontomapper.model.entities.MappingSet;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import lombok.Getter;

import java.util.List;


/**
 * @author Abdelwadoud Rasmi
 * Cached sets
 */
public class CacheSet {
    private static CacheSet instance;
    private MappingSetRepository mappingSetRepository;
    @Getter
    private List<MappingSet> sets;

    /**
     *
     */
    public static CacheSet getInstance(MappingSetRepository mappingSetRepository) {
        if (instance == null)
            instance = new CacheSet(mappingSetRepository);
        return instance;
    }

    /**
     * Private constructor
     */
    private CacheSet(MappingSetRepository mappingSetRepository) {
        this.mappingSetRepository = mappingSetRepository;
        rearm();
    }

    /**
     * reread mappings from db
     * This is a heavy operation, but should be fine since sets number is not big
     */
    public CacheSet rearm() {
        sets = mappingSetRepository.findAll();
        return this;
    }


}
