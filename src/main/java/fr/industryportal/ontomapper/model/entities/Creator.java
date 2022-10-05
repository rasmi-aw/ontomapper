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
 * Entity for mappingset creator
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Creator {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String label;

    /**
     * @// TODO: 10/5/22 add the other needed information about this creator(His name etc...)
     */

    @Getter
    @Setter
    @ManyToMany
    private List<MappingSet> sets;

    @Getter
    @Setter
    @ManyToMany
    private List<Mapping> mappings;

}
