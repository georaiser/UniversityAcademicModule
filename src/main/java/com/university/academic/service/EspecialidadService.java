package com.university.academic.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.academic.entity.Especialidad;
import com.university.academic.repository.AlumnoCursoRepository;
import com.university.academic.repository.EspecialidadRepository;


@Service
public class EspecialidadService {
	
	@Autowired
	public EspecialidadRepository especialidadRepository;
	
	@Autowired
	public AlumnoCursoRepository alumnoCursoRepository;

	public Optional<Especialidad> findById(Integer especialidadId) {
		return especialidadRepository.findById(especialidadId);
	}

	public List<Especialidad> findAll(){
		return especialidadRepository.findAll();
	}
	
	public Especialidad save(Especialidad especialidad) {
		return especialidadRepository.save(especialidad);	
	}
	
	public void deleteById(Integer especialidadId) {
		especialidadRepository.deleteById(especialidadId);
	}
	
}
