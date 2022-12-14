package fr.industryportal.ontomapper.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Entity for a author
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(name = "", columnList = "contributor_id", unique = true)})
public class Contributor {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String contributor_id;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    @OneToMany(mappedBy = "contributor")
    @JsonIgnore
    private List<Contribution> contributions;

    @Getter
    @Setter
    @JsonIgnore
    private boolean deleted;
}
