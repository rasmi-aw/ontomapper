package fr.industryportal.ontomapper;

import fr.industryportal.ontomapper.model.repos.ContributionRepository;
import fr.industryportal.ontomapper.model.repos.ContributorRepository;
import fr.industryportal.ontomapper.model.repos.MappingRepository;
import fr.industryportal.ontomapper.model.repos.MappingSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Abdelwadoud Rasmi
 * This is the main entrypoint of the app
 */
@SpringBootApplication
@EnableScheduling
public class OntomapperApplication implements CommandLineRunner {

    @Autowired
    private MappingSetRepository mappingSetRepository;

    @Autowired
    private MappingRepository mappingRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private ContributionRepository contributionRepository;

    public static void main(String[] args) {
        SpringApplication.run(OntomapperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        //Generating fake data
//        for (int i = 0; i < 100; i++) {
//            MappingSet set = mappingSetRepository.save(new MappingSet(null, "set" + i, "version" + i, null, "description" + i, null, "license" + i, EntityType.RDFS_DATATYPE, "", "", EntityType.RDFS_CLASS, "", "", "", "", new Date(), "", "", "", "", "", "", "", new Date(), null));
//            for (int j = 0; j < 1000; j++) {
//                Mapping mapping = mappingRepository.save(new Mapping(null,
//                        i+"mapping" + j, "subject" + j, "label" + j, "category" + i, "", "", PredicateModifier.NOT, "", "", "",
//                        "", null, "", EntityType.RDFS_DATATYPE, "", "", EntityType.OWL_CLASS, "", "", "",
//                        "", MappingCardinality.MANY_TO_MANY, "", "", new Date(), 0, "", "", "", "",
//                        "", 0, "", "", "", "", new Date(), set));
//            }
//        }
//
//        for (int i = 0; i < 100; i++) {
//            Contributor contributor = contributorRepository.save(new Contributor(null, "contributor" + i, "label" + i, null));
//                contributionRepository.save(new Contribution(null, contributor, ContributorType.AUTHOR, mappingSetRepository.findAll(), mappingRepository.findAll()));
//                contributionRepository.save(new Contribution(null, contributor, ContributorType.CREATOR, mappingSetRepository.findAll(), null));
//                contributionRepository.save(new Contribution(null, contributor, ContributorType.REVIEWER, mappingSetRepository.findAll(), mappingRepository.findAll()));
//
//        }


    }
}
