package ar.edu.ies6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "aaa.bbb.ccc.*"})
public class PyBdMayoMesa2024MirandaMeallaFaustoSantiagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyBdMayoMesa2024MirandaMeallaFaustoSantiagoApplication.class, args);
	}

}
