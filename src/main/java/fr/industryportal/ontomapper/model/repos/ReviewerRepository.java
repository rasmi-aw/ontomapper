package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
}
