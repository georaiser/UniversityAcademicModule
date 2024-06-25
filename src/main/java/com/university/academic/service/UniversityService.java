package com.university.academic.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.academic.entity.Alumno;
import com.university.academic.entity.Curso;
import com.university.academic.entity.EvalAlumnoCurso;
import com.university.academic.repository.AlumnoRepository;
import com.university.academic.repository.CursoRepository;
import com.university.academic.repository.EvalAlumnoCursoRepositorio;

@Service
public class UniversityService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
    private AlumnoRepository alumnoRepository;
	
	@Autowired
    private EvalAlumnoCursoRepositorio evalAlumnoCursoRepositorio;

    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> findCursosByEspecialidadId(Integer especialidadId) {
        return cursoRepository.findByEspecialidadEspecialidadId(especialidadId);
    }

    public List<Alumno> findAlumnosByCursoId(Integer cursoId) {
        return alumnoRepository.findByAlumnoCursosCursoCursoId(cursoId);
    }
    
    public List<EvalAlumnoCurso> findByAlumnoCursoCursoCursoIdAndAlumnoCursoAlumnoAlumnoId(Integer cursoId, Integer alumnoId){
    	return  evalAlumnoCursoRepositorio.findByAlumnoCursoCursoCursoIdAndAlumnoCursoAlumnoAlumnoId(cursoId, alumnoId);
    }
    
    public List<EvalAlumnoCurso> findByAlumnoCursoCursoCursoId(Integer cursoId){
    	return  evalAlumnoCursoRepositorio.findByAlumnoCursoCursoCursoId(cursoId);
    }
    
    public Map<Integer, Double> getMeanGradesByAlumnoForCourse(Integer cursoId) {
        List<EvalAlumnoCurso> evaluations = evalAlumnoCursoRepositorio.findByAlumnoCursoCursoCursoId(cursoId);

        return evaluations.stream()
            .collect(Collectors.groupingBy(
                eval -> eval.getAlumnoCurso().getAlumno().getAlumnoId(),
                Collectors.averagingDouble(EvalAlumnoCurso::getNota)
            ));
    }
    
    
    
    
    
    
}