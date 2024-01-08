package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "auhtors_books")
public class PseudonymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String pseudonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    List<AuthorEntity> authorEntity;

}
