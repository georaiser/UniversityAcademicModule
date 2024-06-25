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
@Table(name = "evaluacion")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_id")
    private Integer evaluacionId;

    @Column(name = "evaluacion_descripcion", nullable = false)
    private String evaluacionDescripcion;

    @OneToMany(mappedBy = "evaluacion")
    private List<EvalAlumnoCurso> evaluacionAlumnoCursos;

    public Evaluacion(String evaluacionDescripcion) {
        this.evaluacionDescripcion = evaluacionDescripcion;
    }
}