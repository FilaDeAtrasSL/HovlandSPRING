package com.HFA.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return repositorio.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Droga> devolverUnaDrogaId(@PathVariable("id") Integer id){
		return repositorio.findById(id);
	}
	
}
