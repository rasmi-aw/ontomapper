package fr.industryportal.ontomapper.model.entities;


import fr.industryportal.ontomapper.model.entities.enums.ContributorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Entity for a contributor, he can be an author, reviewer
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contribution {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @OneToOne
    private User user;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private ContributorType type;

    @Getter
    @Setter
    @ManyToMany
    private List<MappingSet> sets;

    @Getter
    @Setter
    @ManyToMany
    private List<Mapping> mappings;
}
