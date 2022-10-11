package fr.industryportal.ontomapper.model.requests;

import fr.industryportal.ontomapper.helpers.DBCast;
import fr.industryportal.ontomapper.model.entities.Contributor;
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
public class ContributorRequest implements DBCast<Contributor, Void> {

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

    @Override
    public Contributor toDBModel(Void unused) {
        return new Contributor(null, id, label, null);
    }
}
