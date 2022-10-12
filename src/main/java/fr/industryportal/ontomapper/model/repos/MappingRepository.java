package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 */
public interface MappingRepository extends JpaRepository<Mapping, Long> {

    /**
     * get a list of mappings depending based on their set_id, and "after <= id < before"
     */
    @Query(value = "SELECT * FROM Mapping m WHERE (set_id = :setId) AND (id >= :afterOrEqual)  LIMIT 50 ", nativeQuery = true)
    List<Mapping> findFiftyBySetIdAndIdAndIdAfter(long setId, long afterOrEqual);


}
