package fr.industryportal.ontomapper.cache;

import fr.industryportal.ontomapper.model.entities.Mapping;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Abdelwadoud Rasmi
 * Cached mappings
 */
public class CacheMapping {
    private static CacheMapping instance;
    private MappingRepository mappingRepository;
    @Getter
    private HashMap<String, List<Mapping>> mappings;

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
        mappings = new HashMap<>();
    }

    /**
     * Cache a list of mappings by query
     */
    public List<Mapping> get(Long set_id, Long from) {
        String query = set_id + "," + from;
        if (mappings.containsKey(query))
            return mappings.get(query);
        //
        List<Mapping> ms = mappingRepository.findFiftyBySetIdAndIdAndIdAfter(set_id, from);
        if (!ms.isEmpty())
            mappings.put(query, ms);
        return ms;
    }

    /**
     * Unify objects used in different queries in memory to use less RAM
     */
    public CacheMapping unify() {
        for (String q : mappings.keySet()) {
            // get all mappings for every query
            List<Mapping> ms = mappings.get(q);
            // exclude the current query to not compare it to itself
            Set<String> excluded = mappings.keySet();
            excluded.remove(q);
            // for every other query compare mappings with current query mappings and unify similar objects (take the last added version and make it the only)
            for (String q1 : excluded) {
                List<Mapping> ms1 = mappings.get(q1);
                //
                ms.forEach(m -> {
                    int i = ms1.indexOf(m);
                    if (i > -1) {
                        Mapping lastVersion = ms1.get(i);
                        int j = ms.indexOf(m);
                        ms.remove(j);
                        ms.add(j, lastVersion);
                    }

                });

            }
        }
        return this;
    }

}
