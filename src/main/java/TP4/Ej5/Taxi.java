/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KevinDL
 */
public class Taxi {
    //Rec. compartido
    private Semaphore hayCliente = new Semaphore(0);
    private Semaphore asiento = new Semaphore(1, true);
    private Semaphore enDestino = new Semaphore(0);
    private String pasajeroActualAux;//DEBUG

    Taxi(String generarUnId) {
        //...
    }
    
    public void acquireHayCliente(){
        try{
            hayCliente.acquire();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
    public synchronized void acquireAsiento(String id){
        //DEGUG: Los synchronized sirven para la consistencia de los mensajes
        try{
            asiento.acquire();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        synchronized(this){
            this.pasajeroActualAux = id;//DEBUG
        }
    }
    
    public void acquireEnDestino(){    
        try{
            enDestino.acquire();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void releaseHayCliente(){
        hayCliente.release();
    }
    
    public void releaseAsiento(){
        asiento.release();
    }
    
    public void releaseEnDestino(){
        enDestino.release();
    }

    public String getPasajeroActualAux() {
        return pasajeroActualAux;
    }
}
