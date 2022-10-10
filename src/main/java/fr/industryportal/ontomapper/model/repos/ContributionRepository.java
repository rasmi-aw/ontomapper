package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface ContributionRepository extends JpaRepository<Contribution, Long> {
}
