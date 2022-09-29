/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

/**
 *
 * @author KevinDL
 */
public class Chofer implements Runnable{

    private String id;
    private Taxi taxi;

    public Chofer(String id, Taxi taxi) {
        this.id = id;
        this.taxi = taxi;
    }

    private void esperarCliente() {
        //Simula esperar un cliente
        this.taxi.acquireHayCliente();//Espera
        Debugger.hayCliente(id, this.taxi.getPasajeroActualAux());//DEBUG
    }

    private void manejar() {
        //Maneja hasta el destino
        String pasajero = this.taxi.getPasajeroActualAux();
        Debugger.manejar(id, pasajero);//DEBUG
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.taxi.releaseEnDestino();
        Debugger.enDestino(id, pasajero);//DEBUG
    }

    public void run() {
        while (true) {
            esperarCliente();
            manejar();//Cliente a bordo
            this.taxi.releaseEnDestino();//Se baja el cliente
        }
        
    }
}
