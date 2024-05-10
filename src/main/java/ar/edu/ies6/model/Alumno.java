package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Alumno {
	@Id
	private Integer dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String direccion;
	@Column
	private int telefono;
	@Column
	private LocalDate fecNac;
	//@Column
	//private boolean estado;
	

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	//public Boolean getEstado() {
     //return estado;
	//}


    //public void setEstado(Boolean estado) {
		//this.estado = estado;
	//}

	
	public Integer getEdad() {
		int edad = 0;
		
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fecNac, fechaActual);
		edad = periodo.getYears();
		return edad;
	}
	
	
}
