package fr.industryportal.ontomapper.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String label;
}
