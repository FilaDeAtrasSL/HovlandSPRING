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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.HFA.app.entidad.Droga;
import com.HFA.app.repositorio.DrogaRepository;

@RestController
@RequestMapping("drogas")
public class DrogaController {
	
	@Autowired
	DrogaRepository repositorio;

	@GetMapping
	public List<Droga> devolverDrogas(){
		return this.repositorio.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Droga> devolverUnaDrogaId(@PathVariable("id") Integer id){
		return this.repositorio.findById(id);
	}
	
	@PostMapping
	@ResponseBody
	public String anyadirDroga(@RequestBody Droga droga) {
		this.repositorio.save(droga);
		
		return "Perfecto ya se ha guardado la droga que me has mandado!!!";
	}

	@DeleteMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<?> borrarDroga (@PathVariable("id") Integer idDroga){
		
		Optional<Droga> drogaActual = this.repositorio.findById(idDroga);
		
		if (!drogaActual.isPresent()) {
			System.out.println("No existe la droga con el id: " + idDroga);
			
			return new ResponseEntity<>("Error, no existe la droga con id: " + idDroga, HttpStatus.NOT_FOUND);
		}
		
		this.repositorio.deleteById(idDroga);
		
		return new ResponseEntity<String>("Se ha borrado!", HttpStatus.OK);
		
	}
	
	@PutMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<?> modificarDroga(@PathVariable("id") Integer idDroga, @RequestBody Droga nuevaDroga){
		
		System.out.println("Vamos a modificar la droga con id + " + idDroga);
		Optional<Droga> drogaActual = this.repositorio.findById(idDroga);
		
		if (!drogaActual.isPresent()) {
		
			System.out.println("No existe la droga con id " + idDroga);
			return new ResponseEntity("Error, no existe el cliente con id " + idDroga, HttpStatus.NOT_FOUND);
		}
		
		drogaActual.get().setNombre(nuevaDroga.getNombre());
		drogaActual.get().setLegalidad(nuevaDroga.getLegalidad());
		drogaActual.get().setPsicoactivo(nuevaDroga.getPsicoactivo());
		drogaActual.get().setPrecioGramo(nuevaDroga.getPrecioGramo());
		drogaActual.get().setProveedor(nuevaDroga.getProveedor());
		drogaActual.get().setPedidos(nuevaDroga.getPedidos());
		
		this.repositorio.save(drogaActual.get());
		return new ResponseEntity<Droga>(drogaActual.get(), HttpStatus.OK);
		
	}
	
}

