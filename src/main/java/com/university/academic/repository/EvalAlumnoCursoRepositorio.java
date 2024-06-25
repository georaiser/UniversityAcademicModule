package com.university.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.academic.entity.EvalAlumnoCurso;
import java.util.List;



public interface EvalAlumnoCursoRepositorio extends JpaRepository<EvalAlumnoCurso, Integer> {
	
	List<EvalAlumnoCurso> findByAlumnoCursoCursoCursoIdAndAlumnoCursoAlumnoAlumnoId(Integer cursoId, Integer alumnoId);
	
	List<EvalAlumnoCurso> findByAlumnoCursoCursoCursoId(Integer cursoId);

}
