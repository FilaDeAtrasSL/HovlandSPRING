package com.HFA.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HFA.app.entidad.Cliente;
import com.HFA.app.repositorio.ClienteRepository;


@RestController
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	@GetMapping("clientes")
	public List<Cliente> devolverClientes(){
		return this.repository.findAll();
	}
	
}
