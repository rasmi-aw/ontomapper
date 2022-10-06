package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}
