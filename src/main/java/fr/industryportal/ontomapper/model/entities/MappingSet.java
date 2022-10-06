package fr.industryportal.ontomapper.model.entities;


import fr.industryportal.ontomapper.model.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
    private String version;

    @Getter
    @Setter
    @OneToMany
    private List<MappingSet> source;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToMany
    private List<Contributor> creators;

    @Getter
    @Setter
    private String license;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private EntityType subject_type;

    @Getter
    @Setter
    private String subject_source;

    @Getter
    @Setter
    private String subject_source_version;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
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
    @Temporal(TemporalType.TIMESTAMP)
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
    @OneToMany(mappedBy = "set")
    private List<Mapping> mappings;

}
