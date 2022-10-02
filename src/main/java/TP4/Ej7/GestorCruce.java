/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KevinDL
 */
public class GestorCruce {

    private Semaphore sensorInOE = new Semaphore(0, true);
    private Semaphore sensorInNS = new Semaphore(0, true);

    private Semaphore sensorOutOE = new Semaphore(0);
    private Semaphore sensorOutNS = new Semaphore(0);

    public GestorCruce() {
        //...
    }
    
    //Mensajes para Vehiculo
    
    public void llegarOE(String id){
        try{
            this.sensorInOE.acquire();//LLegada
            System.out.println("(...) " + id + " llego a semaforo O-E");//DEBUG
            this.sensorOutOE.acquire();//Cruce
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(-->) " + id + " cruzando O-E");//DEBUG
    }
    
    public void llegarNS(String id){
        try{
            this.sensorInNS.acquire();//Llegada
            System.out.println("(...) " + id + " llego a semaforo N-S");//DEBUG
            this.sensorOutNS.acquire();//Cruce
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(-->) " + id + " cruzando N-S");//DEBUG
    }
    
    public void salirOE(String id){
        System.out.println("(---) "+ id + " cruzo O-E");//DEBUG
        this.sensorOutOE.release();
        this.sensorInOE.release();
    }
    
    public void salirNS(String id){
        System.out.println("(---) "+ id + " cruzo N-S");//DEBUG
        this.sensorOutNS.release();
        this.sensorInNS.release();
    }
    
    //Mensajes para Controlador
    
    public void aVerdeOE(){
        System.out.println("(!!!) SEMAFORO O-E en VERDE");//DEBUG
        this.sensorOutOE.release();
        this.sensorInOE.release();
    }
    
    public void aRojoOE(){
        try{
            this.sensorOutOE.acquire();//Espera a que termine de pasar un auto
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(XXX) SEMAFORO O-E en ROJO");//DEBUG
    }
    
    public void aVerdeNS(){
        System.out.println("(!!!) SEMAFORO N-S en VERDE");//DEBUG
        this.sensorOutNS.release();
        this.sensorInNS.release();
    }
    
    public void aRojoNS(){
        try{
            this.sensorOutNS.acquire();//Espera a que termine de pasar un auto
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(XXX) SEMAFORO N-S en ROJO");//DEBUG
    }
}
