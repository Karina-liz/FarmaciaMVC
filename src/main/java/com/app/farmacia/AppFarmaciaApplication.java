package com.app.farmacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.farmacia.entidad.Empleado;
import com.app.farmacia.repositorio.EmpleadoRepositorio;



@SpringBootApplication
public class AppFarmaciaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppFarmaciaApplication.class, args);
	}
	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Empleado empleado1 = new Empleado("Juan", "Perez", "juan@gmail.com", "123456", 987654321, "Administrador", "09552616", 3000.0);
		empleadoRepositorio.save(empleado1);

		Empleado empleado2 = new Empleado("Maria", "Gomez", "maria@gmail.com", "123456", 987654322, "Vendedor", "09543927", 1500.0);
		empleadoRepositorio.save(empleado2);
	}

}
