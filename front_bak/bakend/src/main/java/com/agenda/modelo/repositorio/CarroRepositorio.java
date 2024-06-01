package com.agenda.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agenda.modelo.entidad.Carro;

@Repository
public interface CarroRepositorio extends CrudRepository<Carro, Integer> {
}
