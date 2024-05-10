package ar.edu.ies6.controller;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.AlumnoService;
//import ar.edu.ies6.util.ListadoAlumno;

@Controller
public class AlumnoController {

	@Autowired
	Alumno alu;
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping({ "/index", "/", "/home", "/alumno" })
	public ModelAndView cargarAlumno() {
		
		//Alumno alu = new Alumno();
		
		//alu.setFechaNac(LocalDate.of(1998, 4, 27));
		//LocalDate.parse("2020-01-08");
		alu.setFecNac(LocalDate.parse("1990-10-27"));
		System.out.println("Edad: "+alu.getEdad());

		// mandar el objeto a la vista
		ModelAndView modelView = new ModelAndView("index");

		modelView.addObject("alumno", alu);

		return modelView;
	}
	
	@PostMapping("/cargarAlumno")
	public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		//primero
		//tengo que cargar el alumno, en donde ESTRUCTURA DE DATOS (BD tablas) LIST ArrayList MAP SET 
		//TODO guardar el alumno en una list
		//ListadoAlumno.getListado().add(alumno);
		//cargar el alumno al array list
		
		alumnoService.guardarAlumno(alumno);
		
		
		ModelAndView modelView = new ModelAndView("listadoAlumnos");
		
		//TODO enviar el listado a la tabla
		//modelView.addObject("listado", ListadoAlumno.getListado());
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;
	}
	
	@GetMapping("/eliminarAlumno/{dni}")
	public String eliminarAlumno(@PathVariable Integer dni) throws Exception {
		alumnoService.eliminarAlumno(dni);
		
		
		//return modelView;
		return "redirect:/mostrarListado";
	}
	
	@GetMapping("/mostarListado")
			public ModelAndView mostrarAlumnos() {
		ModelAndView listado = new ModelAndView("listadoAlumnos");
		listado.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		return listado;
		
	}
	
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception {
		ModelAndView modificarAlumno = new ModelAndView("index");
		modificarAlumno.addObject("alu", alumnoService.encontrarUnAlumno(dni));
		
		
		return modificarAlumno;	
}
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarUnAlumno(@ModelAttribute("alumno") Alumno alumno) {

		alumnoService.guardarAlumno(alumno);
		
		
		ModelAndView modelView = new ModelAndView("listadoAlumnos");
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;
	}
	
}
	

