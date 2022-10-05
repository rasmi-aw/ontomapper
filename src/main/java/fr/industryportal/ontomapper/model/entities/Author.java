package fr.industryportal.ontomapper.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


/**
 * @author Abdelwadoud Rasmi
 * Entity for a author
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    @ManyToMany
    private List<Mapping> mappings;
}
