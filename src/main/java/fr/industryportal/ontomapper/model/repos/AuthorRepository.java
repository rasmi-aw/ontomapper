package fr.industryportal.ontomapper.model.repos;

import fr.industryportal.ontomapper.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Abdelwadoud Rasmi
 */
public interface AuthorRepository extends JpaRepository<Author, String> {
}
