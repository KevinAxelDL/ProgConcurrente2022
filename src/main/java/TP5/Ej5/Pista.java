/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ej5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Pista {

    //Obj.Pasivo
    private Semaphore semMutex = new Semaphore(1);

    private Semaphore semEspacioPista = new Semaphore(1);

    private Semaphore semEsperaA = new Semaphore(1);
    private Semaphore semEsperaD = new Semaphore(0);

    private int esperaACant = 0;
    private int esperaDCant = 0;
    private int cantAterrizajes = 0;

    //Metodos para Avion
    public void aterrizar(String id) {
        
        try {
            this.semMutex.acquire();//EXM
            System.out.println("(...) "+ id +" esperando para aterrizar");//DEBUG
            this.esperaACant++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.semMutex.release();//EXM

        try {
            semEsperaA.acquire();//Puede aterrizar
            this.semMutex.acquire();//EXM
            System.out.println("(-->) "+ id +" aterrizando");//DEBUG
            this.esperaACant--;
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cantAterrizajes++;

        if (this.esperaDCant > 0) {
            //Hay aviones esperando para despegar
            if (cantAterrizajes == 10) {
                //Maxima cantidad de aterrizajes acumulados es 10
                semEsperaD.release();
                this.cantAterrizajes = 0;//Se reinicia
            } else {
                if (this.esperaACant == 0) {
                    //No hay aviones esperando para aterrizar
                    semEsperaD.release();
                }else{
                    //No se cumple ninguna condicion
                    this.semEsperaA.release();//Notifica que la pista esta libre
                }
            }
        }else{
            this.semEsperaA.release();//Notifica que la pista esta libre
        }
        //System.out.println("(!!!) "+ id +" libero la pista");//DEBUG
        this.semMutex.release();//EXM
    }
    
    public void despegar(String id){
        
        try {
            this.semMutex.acquire();//EXM
            System.out.println("(---) "+ id +" quiere despegar");//DEBUG
            this.esperaDCant++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.semMutex.release();//EXM
        
        try {
            this.semEsperaD.acquire();//Puede despegar
            this.semMutex.acquire();//EXM
            System.out.println("(<--) "+ id +" DESPEGO!");//DEBUG
            this.semEsperaA.release();//Notifica que la pista esta libre
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.esperaDCant--;
        
    }
}
