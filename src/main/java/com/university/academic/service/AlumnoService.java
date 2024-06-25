package com.university.academic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.academic.entity.Alumno;
import com.university.academic.entity.Curso;
import com.university.academic.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	public AlumnoRepository alumnoRepository;

	public Optional<Alumno> findById(Integer alumnoId) {
		return alumnoRepository.findById(alumnoId);
	}

	public List<Alumno> findAll(){
		return alumnoRepository.findAll();
	}
	
	public Alumno save(Alumno Alumno) {
		return alumnoRepository.save(Alumno);	
	}
	
	public void deleteById(Integer alumnoId) {
		alumnoRepository.deleteById(alumnoId);
	}

	public void agregarCurso(Curso curso) {
		// TODO Auto-generated method stub
	}

}
