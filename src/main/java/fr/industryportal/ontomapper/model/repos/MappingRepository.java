package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 */
public interface MappingRepository extends JpaRepository<Mapping, Long> {

    /**
     * get a list of mappings depending based on their set_id, and "after <= id < before"
     */
    @Query("SELECT m FROM Mapping m WHERE (m.set.id = :set_id) AND (m.id >= :afterOrEqual) AND (m.id < :before)")
    List<Mapping> findAllBySetIdAndIdBetween(long set_id, long afterOrEqual, long before);
}
