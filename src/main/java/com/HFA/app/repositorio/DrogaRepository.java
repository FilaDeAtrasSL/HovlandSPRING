package com.HFA.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HFA.app.entidad.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Integer>{

}
