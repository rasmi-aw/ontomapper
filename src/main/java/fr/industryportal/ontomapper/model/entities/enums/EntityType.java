package fr.industryportal.ontomapper.model.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Abdelwadoud Rasmi
 * Enumeral values for Entity that is being mapped
 */
@AllArgsConstructor
public enum EntityType {
    OWL_CLASS("owl:Class"),
    OWL_OBJECT_PROPERTY("owl:ObjectProperty"),
    OWL_DATA_PROPERTY("owl:DataProperty"),
    OWL_ANNOTATION_PROPERTY("owl:AnnotationProperty"),
    OWL_NAMED8INDIVIDUAL("owl:NamedIndividual"),
    SKOS_CONCEPT("skos:Concept"),
    RDFS_RESOURCE("rdfs:Resource"),
    RDFS_CLASS("rdfs:Class"),
    RDFS_LITERAL("rdfs:Literal"),
    RDFS_DATATYPE("rdfs:Datatype"),
    RDF_PROPERTY("rdf:Property");

    @Getter
    private final String value;

}