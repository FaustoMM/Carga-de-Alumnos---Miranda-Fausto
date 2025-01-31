package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Integer> {

	//public List<Alumno> findbyEstado(Boolean estado);
	public List<Alumno> findbyDni(Integer dni);
	
}
