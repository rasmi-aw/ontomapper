package fr.industryportal.ontomapper.model.requests;

import fr.industryportal.ontomapper.model.entities.enums.ContributorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Abdelwadoud Rasmi
 * Request model
 */
@AllArgsConstructor
@NoArgsConstructor
public class ContributorRequest {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private ContributorType type;

}
