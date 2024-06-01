package com.agenda.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carro")
public class Carro {

    
    @Id
    private int idCarro;
    private String marca;
    private String modelo;
    private int motor;
    private double precio;

    
    public Carro() {
        super();
    }

    
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        return "Carro [idCarro=" + idCarro + ", marca=" + marca + ", modelo=" + modelo + ", motor=" + motor
                + ", precio=" + precio + "]";
    }
}
