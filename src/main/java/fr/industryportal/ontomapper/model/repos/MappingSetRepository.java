package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.MappingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 */
public interface MappingSetRepository extends JpaRepository<MappingSet, Long> {

    @Query(value = "SELECT * FROM mapping_set WHERE mapping_set_id = :msid AND deleted <> true", nativeQuery = true)
    MappingSet findByStringId(String msid);

    @Override
    @Query(value = "SELECT * FROM mapping_set WHERE deleted <> true ", nativeQuery = true)
    List<MappingSet> findAll();
}
