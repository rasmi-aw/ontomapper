package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Abdelwadoud Rasmi
 */
public interface ContributorRepository extends JpaRepository<Contributor, Long> {

    @Query(value = "SELECT * FROM contributor WHERE contributor_id = :cid", nativeQuery = true)
    Contributor findByContributorId(String cid);
}
