package com.HFA.app.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Cliente> devolverClientes(@RequestParam(value = "nombre", required = false) String nombre, @RequestParam(value = "edad", required = false) Integer edad ){
		List<Cliente> listaClientes = this.repository.findAll();
		ArrayList<Cliente> listaFiltrados = new ArrayList<>();
		
		if (nombre==null && edad == null) {
			return listaClientes;
		}else {
			
				if(edad!=null) {
					
					listaFiltrados = new ArrayList<Cliente>();
					
					for (int i = 0; i < listaClientes.size(); i++) {
						
						if (listaClientes.get(i).getEdad() == edad) {
							listaFiltrados.add(listaClientes.get(i));
						}
						
					}
					
					return listaFiltrados;
					
				}else if(nombre!=null){
					listaFiltrados = new ArrayList<>();
					
					for (int i = 0; i < listaClientes.size(); i++) {
						
						if (listaClientes.get(i).getNombre().equals(nombre)) {
							listaFiltrados.add(listaClientes.get(i));
						}
						
					}
					
					return listaFiltrados;
				}

			}
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
	
	
	@PutMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<?> modificarCliente(@PathVariable("id") int idCliente, @RequestBody Cliente nuevoCliente){
		
		System.out.println("Vamos a modificar el cliente con id + " + idCliente);
		Optional<Cliente> clienteActual = this.repository.findById(idCliente);
		
		if (!clienteActual.isPresent()) {
		
			System.out.println("No existe el cliente con id " + idCliente);
			return new ResponseEntity("Error, no existe el cliente con id " + idCliente, HttpStatus.NOT_FOUND);
		}
		
		clienteActual.get().setNombre(nuevoCliente.getNombre());
		clienteActual.get().setEdad(nuevoCliente.getEdad());
		clienteActual.get().setGenero(nuevoCliente.getGenero());
		clienteActual.get().setNacionalidad(nuevoCliente.getNacionalidad());
		clienteActual.get().setPedidos(nuevoCliente.getPedidos());
		
		this.repository.save(clienteActual.get());
		return new ResponseEntity<Cliente>(clienteActual.get(), HttpStatus.OK);
		
	}
	
	}
	

