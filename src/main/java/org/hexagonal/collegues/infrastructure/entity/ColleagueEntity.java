package org.hexagonal.collegues.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colleagues")
public class ColleagueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colleagueId;

    private String name;

    private String dni;
}
