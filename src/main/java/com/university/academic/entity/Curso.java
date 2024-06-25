package com.university.academic.entity;

import java.util.List;

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
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Integer cursoId;

    @Column(name = "curso_descripcion", nullable = false)
    private String cursoDescripcion;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<AlumnoCurso> alumnoCursos;

    public Curso(String cursoDescripcion, Especialidad especialidad, Profesor profesor) {
        this.cursoDescripcion = cursoDescripcion;
        this.especialidad = especialidad;
        this.profesor = profesor;
    }
}