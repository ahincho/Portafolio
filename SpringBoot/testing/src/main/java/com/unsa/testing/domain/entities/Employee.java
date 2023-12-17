package com.unsa.testing.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "email", nullable = false)
    private String email;
}
