package com.university.academic.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.academic.entity.Curso;
import com.university.academic.repository.AlumnoCursoRepository;
import com.university.academic.repository.CursoRepository;


@Service
public class CursoService {
	
	@Autowired
	public CursoRepository cursoRepository;
	
	@Autowired
	public AlumnoCursoRepository alumnoCursoRepository;

	public Optional<Curso> findById(Integer cursoId) {
		return cursoRepository.findById(cursoId);
	}

	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);	
	}
	
	public void deleteById(Integer cursoId) {
		cursoRepository.deleteById(cursoId);
	}
	
}
