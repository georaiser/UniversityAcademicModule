package com.university.academic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.academic.entity.Alumno;
import com.university.academic.entity.EvalAlumnoCurso;
import com.university.academic.service.EspecialidadService;
import com.university.academic.service.UniversityService;

@Controller
@RequestMapping("/vistas")
public class VistasController {
	
	@Autowired
    private EspecialidadService especialidadService;
    
    @Autowired
    private UniversityService universityService;
    

    @GetMapping("/especialidad")
    public String showForm(Model model) {
    	model.addAttribute("especialidades", especialidadService.findAll());
        model.addAttribute("cursos", universityService.findAllCursos());
        return "actions/alumnoespecialidadcurso_form";
    }
    
    @GetMapping("/search")
    public String searchAlumnos(@RequestParam(required = false) Integer especialidadId,
            					@RequestParam(required = false) Integer cursoId, 
            					Model model) {
		model.addAttribute("especialidades", especialidadService.findAll());
		model.addAttribute("selectedEspecialidadId", especialidadId);
		model.addAttribute("selectedCursoId", cursoId);
		
		if (especialidadId != null) {
			// modificar filtro de cursos segun especialidad. actualiza filtro curso, no despliega alumnos.
			model.addAttribute("cursos", universityService.findCursosByEspecialidadId(especialidadId));
			} else {
			model.addAttribute("cursos", universityService.findAllCursos());
		}
		
		if (cursoId != null) {
			Map<Integer, Double> meanGradesByAlumno = universityService.getMeanGradesByAlumnoForCourse(cursoId);
	        List<Alumno> alumnos = universityService.findAlumnosByCursoId(cursoId);
	        
	        model.addAttribute("alumnos", alumnos);
	        model.addAttribute("meanGrades", meanGradesByAlumno);		
		}
        return "actions/alumnoespecialidadcurso_form";
    }
}







