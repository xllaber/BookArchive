package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "sagas")
@Entity
public class SagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    @Column(name = "publish_start")
    Integer publishStart;
    @Column(name = "publish_end")
    Integer publishEnd;

}
