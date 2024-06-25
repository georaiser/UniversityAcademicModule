package com.university.academic.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "asistencia_alumno_curso")
public class AsistenciaAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistencia_alumno_curso")
    private Integer asistenciaAlumnoCurso;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id", nullable = false)
    private AlumnoCurso alumnoCurso;

    @Column(name = "asiste", nullable = false)
    private Boolean asiste;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    public AsistenciaAlumnoCurso(AlumnoCurso alumnoCurso, Boolean asiste, LocalDate fecha) {
        this.alumnoCurso = alumnoCurso;
        this.asiste = asiste;
        this.fecha = fecha;
    }
}