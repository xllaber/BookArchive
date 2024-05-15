package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rereads")
@Entity
public class RereadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "book_id")
    Long bookId;
    String impressions;
    @Column(name = "start_date")
    LocalDate startDate;
    @Column(name = "finish_date")
    LocalDate finishDate;

}
