package com.university.academic.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer profesorId;

    @Column(name = "profesor_nombre", nullable = false)
    private String profesorNombre;

    @Column(name = "profesor_email", nullable = false)
    private String profesorEmail;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    public Profesor(String profesorNombre, String profesorEmail) {
        this.profesorNombre = profesorNombre;
        this.profesorEmail = profesorEmail;
    }
}