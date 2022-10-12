/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemasClasicos.ProductorConsumidorV1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin.dittler
 */
public class Buffer {
    private Semaphore  mutex = new Semaphore (1);//Exclusion mutua
    private Semaphore espacio;//Semaforo generico
    private int espacioMax;
    
    public Buffer(int espacio){
        this.espacio = new Semaphore(espacio);
        this.espacioMax = espacio;
    }
    
    private void acquireMutex(){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Metodos para Consumidor
    public void consumir(String id){
        acquireMutex();//
        try {
            espacio.acquire();//Quita
        } catch (InterruptedException ex) {
            System.out.println(ex);;
        }
        
        mutex.release();
    }
    
    //Metodos para Productor
    public void agregar(String id){
        acquireMutex();//
        
        espacio.release();//Agrega
        
        mutex.release();
    }
}
