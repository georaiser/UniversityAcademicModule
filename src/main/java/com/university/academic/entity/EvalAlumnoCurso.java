package com.university.academic.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "evaluacion_alumno_curso")
public class EvalAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_alumno_curso")
    private Integer evaluacionAlumnoCurso;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id", nullable = false)
    private AlumnoCurso alumnoCurso;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private Evaluacion evaluacion;

    @Column(name = "nota", nullable = false)
    private Double nota;

    public EvalAlumnoCurso(AlumnoCurso alumnoCurso, Evaluacion evaluacion, Double nota) {
        this.alumnoCurso = alumnoCurso;
        this.evaluacion = evaluacion;
        this.nota = nota;
    }
}