/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej5;

/**
 *
 * @author KevinDL
 */
public abstract class Vehiculo implements Runnable {
    protected String id;
    protected String modelo;
    protected int km;
    protected int consumoXKm;
    protected int capacidadLitros;
    protected Surtidor[] colSurtidores;
    protected int capacidadLitrosActual;
    
    public Vehiculo(String id, String modelo, Surtidor[] colSurtidores){
        this.id = id;
        this.modelo = modelo;
        this.km = 0;;
        this.colSurtidores = colSurtidores;
    }

    public String getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKm() {
        return km;
    }

    public int getConsumoXKm() {
        return consumoXKm;
    }

    public int getCapacidadLitros() {
        return capacidadLitros;
    }

    public int getCapacidadLitrosActual() {
        return capacidadLitrosActual;
    }
    
    public void run(){
        //Implementacion delegada a las subclases
    }
    
}
