package fr.industryportal.ontomapper.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private MappingSet set;
}
