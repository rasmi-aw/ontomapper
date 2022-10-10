package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface MappingRepository extends JpaRepository<Mapping, Long> {
}
