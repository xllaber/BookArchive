package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rereads")
public class RereadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String impressions;
    @Column(name = "start_date")
    Date startDate;
    @Column(name = "finish_date")
    Date finishDate;

}
