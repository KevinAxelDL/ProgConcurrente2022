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
            //Puede implementarse mejor esta espera
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Ya esta en el hangar
        try {
            this.semMutexD.acquire();//EXM

            this.esperaDCant++;//Se suma a los aviones esperando en el hangar
            this.cantAterrizajes++;
            System.out.println("Cant.Aterrizajes [" + this.cantAterrizajes + "/10]");

            if (this.esperaDCant > 0) {
                //Hay aviones esperando para despegar
                if (cantAterrizajes == 10) {
                    //Maxima cantidad de aterrizajes acumulados es 10
                    System.out.println("Maxima cantidad de aterrizajes acumulados es 10!");//DEBUG
                    this.cantAterrizajes = 0;//Se reinicia
                    semEsperaD.release();
                } else {

                    if (this.esperaACant == 0) {
                        System.out.println("No hay aviones esperando para aterrizar!");//DEBUG
                        //No hay aviones esperando para aterrizar
                        semEsperaD.release();
                    } else {
                        //No se cumple ninguna condicion
                        System.out.println("(!) pista despejada");//DEBUG
                        this.semEsperaA.release();//Notifica que la pista esta libre
                    }
                }
            } else {
                System.out.println("(!) pista despejada");//DEBUG
                this.semEsperaA.release();//Notifica que la pista esta libre
            }
            this.semMutexD.release();//EXM
            this.semMutexA.release();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void despegar(String id) {

        System.out.println("--- " + id + " quiere despegar");//DEBUG

        try {
            this.semEsperaD.acquire();//Espera para despegar
            System.out.println("<-- " + id + " DESPEGO!");//DEBUG

            try {
                //NOTA: Nadie puede usar las pista mientas un avion despega
                //Puede implementarse mejor esta espera
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Ya despeguo
            this.semMutexA.acquire();//EXM
            if (this.esperaACant == 0) {
                //No hay nadie esperando para aterrizar, notifica que otros pueden despegar
                this.semEsperaD.release();
            } else {
                if (this.esperaACant > 0) {
                    //Hay aviones esperando para aterrizar, tienen prioridad
                    this.semEsperaA.release();//Notifica que la pista esta libre
                }
            }
            this.semMutexA.release();//EXM
            this.semMutexD.acquire();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.esperaDCant--;
        this.semMutexD.release();//EXM
    }
}
