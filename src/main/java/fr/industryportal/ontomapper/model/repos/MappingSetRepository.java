package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.MappingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Abdelwadoud Rasmi
 */
public interface MappingSetRepository extends JpaRepository<MappingSet, Long> {

    @Query(value = "SELECT * FROM mapping_set WHERE mapping_set_id = :msid ", nativeQuery = true)
    MappingSet findByStringId(String msid);

}
