package com.spring.universidad.universidadbackend;

import com.spring.universidad.universidadbackend.modelo.entidades.Alumno;
import com.spring.universidad.universidadbackend.modelo.entidades.Direccion;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {

	@Autowired
	private AlumnoDAO servicio;

	public static void main(String[] args) {
		String[] str = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/*for (String s: str) {
			System.out.println(s);
		}*/
	}

	@Bean
	public CommandLineRunner runner(){
		return  args -> {
			/*Direccion direccion = new Direccion("Calle falsa","321","1234", "", "","Argenzuela");
			Persona alumno = new Alumno(null, "Pedro", "Ramirez", "12345679",direccion);

			Persona save = servicio.save(alumno);*/
			List<Persona> alumnos = (List<Persona>) servicio.findAll();
			for (Persona a : alumnos) {
				System.out.println(a);
			}
		};
	}
}
