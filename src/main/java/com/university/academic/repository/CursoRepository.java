package com.university.academic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.academic.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByEspecialidadEspecialidadId(Integer especialidadId);

}
