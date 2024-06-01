package com.agenda.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.modelo.entidad.Carro;
import com.agenda.modelo.repositorio.CarroRepositorio;

@Service
public class CarroServicio implements ICarroServicio {
     
	@Autowired
	private CarroRepositorio carroRepositorio;
	
	@Override
	public List<Carro> listaTodos() {
		return (List<Carro>) carroRepositorio.findAll();
	}

	@Override
	public void guardar(Carro carro) {
		carroRepositorio.save(carro);
	}

	@Override
	public Carro buscarPorId(Integer id) {
		return carroRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		carroRepositorio.deleteById(id);
	}
}
