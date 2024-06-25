package com.university.academic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.academic.entity.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	List<Alumno> findByAlumnoCursosCursoCursoId(Integer cursoId);

}
