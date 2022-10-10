package fr.industryportal.ontomapper.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * Entity for a author
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class Contributor {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    @OneToMany(mappedBy = "contributor")
    @JsonIgnore
    private List<Contribution> contributions;
}
