package com.app.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.farmacia.entidad.Cliente;
import com.app.farmacia.repositorio.ClienteDAO;
import java.time.LocalDateTime;


@SpringBootApplication
public class AppFarmaciaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppFarmaciaApplication.class, args);
	}


	@Autowired
	private ClienteDAO clienteDao;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente("Juan", "Perez", "123456789", "juan@gmail.com", "123456", 987654321, "Av. Principal 123", LocalDateTime.now());
		clienteDao.save(cliente);
	}

}
