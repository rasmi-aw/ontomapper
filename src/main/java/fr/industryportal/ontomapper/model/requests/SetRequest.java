package fr.industryportal.ontomapper.model.requests;

import fr.industryportal.ontomapper.model.entities.Contribution;
import fr.industryportal.ontomapper.model.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Request model
 */
@AllArgsConstructor
@NoArgsConstructor
public class SetRequest {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String mapping_set_id;

    @Getter
    @Setter
    private String version;

    @Getter
    @Setter
    private List<SetRequest> source;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<Contribution> creators;

    @Getter
    @Setter
    private String license;

    @Getter
    @Setter
    private EntityType subject_type;

    @Getter
    @Setter
    private String subject_source;

    @Getter
    @Setter
    private String subject_source_version;

    @Getter
    @Setter
    private EntityType object_type;

    @Getter
    @Setter
    private String object_source;

    @Getter
    @Setter
    private String object_source_version;

    @Getter
    @Setter
    private String mapping_provider;

    @Getter
    @Setter
    private String mapping_tool;

    @Getter
    @Setter
    private Date mapping_date;

    @Getter
    @Setter
    private String subject_match_field;

    @Getter
    @Setter
    private String object_match_field;

    @Getter
    @Setter
    private String subject_preprocessing;

    @Getter
    @Setter
    private String object_preprocessing;

    @Getter
    @Setter
    private String see_also;

    @Getter
    @Setter
    private String other;

    @Getter
    @Setter
    private String comment;

    @Getter
    @Setter
    private List<MappingRequest> mappings;

    private toDBModel

}
