package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ies6.model.Alumno;

public class ListadoAlumno {
	private static List <Alumno> listado = new ArrayList<>();
	
	 public ListadoAlumno() {
		// TODO Auto-generated constructor stub
	}

	public static List<Alumno> getListado() {
		return listado;
	}

	public static void setListado(List<Alumno> listado) {
		ListadoAlumno.listado = listado;
	}
	 
	 

}
