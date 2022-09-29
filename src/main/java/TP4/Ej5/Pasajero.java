/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

/**
 *
 * @author KevinDL
 */
public class Pasajero implements Runnable {

    private String id;
    private Taxi taxi;

    public Pasajero(String id, Taxi taxi) {
        
        this.id = id;
        this.taxi = taxi;
    }

    private void subirAlTaxi() {
        
        taxi.acquireAsiento(id);//Se sienta
        taxi.releaseHayCliente();//Avisa que subio
    }

    private void bajarDelTaxi() {
        
        taxi.acquireEnDestino();
        taxi.releaseAsiento();//Libera el asiento
    }

    public void run() {
        while (true) {
            subirAlTaxi();
            bajarDelTaxi();
        }
    }
}
