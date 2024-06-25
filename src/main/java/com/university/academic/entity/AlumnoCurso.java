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
@Table(name = "alumno_curso")
public class AlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_curso_id")
    private Integer alumnoCursoId;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "alumnoCurso")
    private List<EvalAlumnoCurso> evaluacionAlumnoCursos;

    @OneToMany(mappedBy = "alumnoCurso")
    private List<AsistenciaAlumnoCurso> asistenciaAlumnoCursos;

    public AlumnoCurso(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
    }
}