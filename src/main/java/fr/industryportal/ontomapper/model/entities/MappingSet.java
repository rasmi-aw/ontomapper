package fr.industryportal.ontomapper.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Entity for a set of mappings
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MappingSet {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @OneToMany(mappedBy = "set")
    private List<Mapping> mappings;

}
