package com.HFA.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HFA.app.entidad.Cliente;
import com.HFA.app.repositorio.ClienteRepository;


@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> devolverClientes(){
		return this.repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Cliente> devolverUnClienteId(@PathVariable("id") Integer idCliente){

		return this.repository.findById(idCliente);

	}
	
}
