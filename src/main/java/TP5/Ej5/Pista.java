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
    private Semaphore semMutexA = new Semaphore(1, true);//Aterrizaje
    private Semaphore semMutexD = new Semaphore(1, true);//Despegue

    //1 espacio en pista
    private Semaphore semEsperaA = new Semaphore(1, true);//Comunicacion con aviones por aterrizar
    private Semaphore semEsperaD = new Semaphore(0, true);//Comunicacion con aviones por despegar

    private int esperaACant = 0;
    private int esperaDCant = 0;
    private int cantAterrizajes = 0;

    //Metodos para Avion
    public void aterrizar(String id) {

        try {
            this.semMutexA.acquire();//EXM
            System.out.println("... " + id + " esperando para aterrizar");//DEBUG
            this.esperaACant++;
            this.semMutexA.release();//EXM

            semEsperaA.acquire();//Espera para aterrizar

            this.semMutexA.acquire();//EXM
            System.out.println("--> " + id + " aterrizando");//DEBUG
            this.esperaACant--;
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //NOTA: Nadie puede usar las pista mientas un avion aterriza
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println("(!!!) " + id + " libero la pista");//DEBUG
        this.cantAterrizajes++;
        System.out.println("Cant.Aterrizajes [" + this.cantAterrizajes + "/10]");

        try {
            this.semMutexD.acquire();//EXM
            if (this.esperaDCant > 0) {
                //Hay aviones esperando para despegar
                if (cantAterrizajes == 10) {
                    //Maxima cantidad de aterrizajes acumulados es 10
                    System.out.println("Maxima cantidad de aterrizajes acumulados es 10!");
                    this.cantAterrizajes = 0;//Se reinicia
                    semEsperaD.release();
                } else {
                    if (this.esperaACant == 0) {
                        System.out.println("No hay aviones esperando para aterrizar!");
                        //No hay aviones esperando para aterrizar
                        semEsperaD.release();
                    } else {
                        //No se cumple ninguna condicion
                        System.out.println("(!) pista despejada");
                        this.semEsperaA.release();//Notifica que la pista esta libre
                    }
                }
            } else {
                System.out.println("(!) pista despejada");
                this.semEsperaA.release();//Notifica que la pista esta libre
            }

            this.semMutexD.release();//EXM
            this.semMutexA.release();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void despegar(String id) {

        try {
            System.out.println("--- " + id + " quiere despegar");//DEBUG
            this.semMutexD.acquire();//EXM
            this.esperaDCant++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.semMutexD.release();//EXM

        try {
            this.semEsperaD.acquire();//Espera para despegar
            this.semMutexD.acquire();//EXM
            System.out.println("<-- " + id + " DESPEGO!");//DEBUG

            try {
                //NOTA: Nadie puede usar las pista mientas un avion despega
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Ya despeguo
            this.semEsperaA.release();//Notifica que la pista esta libre
            this.semMutexA.acquire();//EXM
            if (this.esperaACant == 0) {
                //No hay nadie esperando para aterrizar, notifica que otros pueden despegar
                this.semEsperaD.release();
            }
            this.semMutexA.release();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.esperaDCant--;
        this.semMutexD.release();//EXM
    }
}
