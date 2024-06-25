package com.university.academic.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.academic.entity.Alumno;
import com.university.academic.entity.Curso;
import com.university.academic.service.AlumnoService;
import com.university.academic.service.CursoService;


@Controller
@RequestMapping("/matricular")
public class MatricularController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private CursoService cursoService;
    
    

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/matricula")
    public String mostrarFormularioInscripcion(Model model) {
        model.addAttribute("alumnos", alumnoService.findAll());
        model.addAttribute("cursos", cursoService.findAll());
        return "actions/matricula_form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/alumno-curso") 
    public String inscribirAlumnoACurso(@RequestParam Integer alumnoId, @RequestParam Integer cursoId) {
        Optional<Alumno> alumno = alumnoService.findById(alumnoId);
        Optional<Curso> curso = cursoService.findById(cursoId);

        return "matricula/matricula_form";
    }
}