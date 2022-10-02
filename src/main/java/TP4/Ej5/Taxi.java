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
    private Semaphore asiento = new Semaphore(1);
    private Semaphore enDestino = new Semaphore(0);

    Taxi(String generarUnId) {
        //...
    }
    
    //Mensajes para Chofer
    
    public void esperarCliente(){
        System.out.println("(...) CHOFER espera un cliente");//DEBUG
        try{
            hayCliente.acquire();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("(!!!) CHOFER arranca");//DEBUG
    }
    
    public void notificarEnDestino(){
        System.out.println("(D!!) CHOFER llego a destino");
        this.enDestino.release();
    }
    
    //Mensajes para Pasajero
    
    public void sentarse(String id){
        System.out.println("(---) "+ id +" espera el taxi");//DEBUG
        try{
            asiento.acquire();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("(-->) "+ id +" subio al taxi!");//DEBUG
        hayCliente.release();
    }
    
    public void abajarse(String id){
        try{
            enDestino.acquire();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(<--) "+ id +" libera el taxi");//DEBUG
        asiento.release();
    }
}
