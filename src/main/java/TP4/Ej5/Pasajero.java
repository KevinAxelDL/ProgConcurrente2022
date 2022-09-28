/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

/**
 *
 * @author KevinDL
 */
public class Pasajero implements Runnable{

    private String id;
    private Taxi taxi;

    public Pasajero(String id, Taxi taxi) {
        this.id = id;
        this.taxi = taxi;
    }
    
    private void subirAlTaxi(){
        try{
            taxi.acquireAsiento();//Se sienta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(this.id +" subio al taxi");
        taxi.releaseHayCliente();//Avisa que subio
    }
    
    private void bajarDelTaxi(){
        try{
            taxi.acquireEnDestino();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        taxi.releaseAsiento();//Libera el taxi
        System.out.println(this.id +" baja del taxi");
    }

    public void run() {
        while (true) {
            subirAlTaxi();
            bajarDelTaxi();
        }
    }
}
