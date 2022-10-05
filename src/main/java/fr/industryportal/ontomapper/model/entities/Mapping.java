package fr.industryportal.ontomapper.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.industryportal.ontomapper.model.entities.embeddables.PredicateModifier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Entity for a mapping
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mapping {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String subject_id;

    @Getter
    @Setter
    private String subject_label;

    @Getter
    @Setter
    private String subject_category;

    @Getter
    @Setter
    private String predicate_id;

    @Getter
    @Setter
    private String predicate_label;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private PredicateModifier predicate_modifier;

    @Getter
    @Setter
    private String object_id;

    @Getter
    @Setter
    private String object_label;

    @Getter
    @Setter
    private String object_category;

    @Getter
    @Setter
    private String justification;

    @Getter
    @Setter
    @ManyToMany
    private List<Author> authors;

    @Getter
    @Setter
    @ManyToMany
    private List<Reviewer> reviewers;



    @Getter
    @Setter
    @ManyToOne
    @JsonIgnore
    private MappingSet set;
}
