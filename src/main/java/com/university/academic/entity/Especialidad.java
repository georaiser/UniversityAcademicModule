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
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialidad_id")
    private Integer especialidadId;

    @Column(name = "especialidad_descripcion", nullable = false)
    private String especialidadDescripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<Curso> cursos;

    public Especialidad(String especialidadDescripcion) {
        this.especialidadDescripcion = especialidadDescripcion;
    }
}