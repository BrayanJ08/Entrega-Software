package com.agenda.modelo.servicio;

import java.util.List;

import com.agenda.modelo.entidad.Carro;

public interface ICarroServicio {
    
    public List<Carro> listaTodos();
    public void guardar(Carro carro);
    public Carro buscarPorId(Integer id);
    public void eliminar(Integer id);
}
