package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Abdelwadoud Rasmi
 */
@RepositoryRestResource
public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}
