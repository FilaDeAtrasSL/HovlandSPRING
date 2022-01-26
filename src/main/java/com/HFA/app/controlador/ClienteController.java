package com.HFA.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping
	@ResponseBody
	public String anyadirCliente(@RequestBody Cliente cliente) {
		
		this.repository.save(cliente);
		
		return "Perfecto ya se ha guardado el cliente que me has mandado!!!";
		
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<?> borrarCliente (@PathVariable("id") int idCliente){
		
		Optional<Cliente> clienteActual = this.repository.findById(idCliente);
		
		if (!clienteActual.isPresent()) {
			System.out.println("No existe el cliente con el id: " + idCliente);
			
			return new ResponseEntity<>("Error, no existe el cliente con id: " + idCliente, HttpStatus.NOT_FOUND);
		}
		
		this.repository.deleteById(idCliente);
		
		return new ResponseEntity<String>("Se ha borrado!", HttpStatus.OK);
		
	}
	
}
