package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface CreatorRepository extends JpaRepository<Creator,Long> {
}
