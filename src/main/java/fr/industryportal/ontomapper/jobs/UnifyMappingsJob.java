package fr.industryportal.ontomapper.jobs;

import fr.industryportal.ontomapper.cache.CacheMapping;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Abdelwadoud Rasmi
 * A job that runs x every time to unify the mappings
 */
@Component
public class UnifyMappingsJob implements Job {

    @Autowired
    private MappingRepository mappingRepository;

    @Override
    @Scheduled(fixedRate = HOUR)
    public void execute() {
        CacheMapping
                .getInstance(mappingRepository)
                .unify();
    }
}
