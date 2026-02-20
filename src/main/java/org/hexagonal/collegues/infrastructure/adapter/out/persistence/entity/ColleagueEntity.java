package org.hexagonal.collegues.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colleagues")
public class ColleagueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colleagueId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String dni;
}
