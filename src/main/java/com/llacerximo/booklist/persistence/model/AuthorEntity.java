package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "authors")
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String country;
    Integer birthYear;
    Integer deathYear;
    String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "authors_pseudonyms",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "pseudonym_id")
    )
    List<PseudonymEntity> pseudonymEntities;

}
