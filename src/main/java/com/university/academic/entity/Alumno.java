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
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Integer alumnoId;

    @Column(name = "alumno_nombre", nullable = false)
    private String alumnoNombre;

    @Column(name = "alumno_apellido", nullable = false)
    private String alumnoApellido;

    @Column(name = "alumno_email", nullable = false)
    private String alumnoEmail;

    @OneToMany(mappedBy = "alumno")
    private List<AlumnoCurso> alumnoCursos;

    public Alumno(String alumnoNombre, String alumnoApellido, String alumnoEmail) {
        this.alumnoNombre = alumnoNombre;
        this.alumnoApellido = alumnoApellido;
        this.alumnoEmail = alumnoEmail;
    }
}