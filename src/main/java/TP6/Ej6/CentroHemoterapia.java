/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class CentroHemoterapia {

    private ReentrantLock lockCamillas = new ReentrantLock(true);
    //
    private Condition esperaCamilla = lockCamillas.newCondition();//Condicion a sociada al lock
    private Condition esperaCamillaoRevista = lockCamillas.newCondition();//Condicion a sociada al lock
    //
    private int cantCamillas = 4;
    private int cantCamillasOcu = 0;
    private int cantRevistas = 9;
    private int cantRevistasOcu = 0;
    //

    //Metodos para Paciente
    public void ocuparCamilla(String id) {
        this.lockCamillas.lock();//EXM
        try {
            //EXM
            while (this.cantCamillasOcu >= this.cantCamillas) {
                //El paciente debe esperar a que se desocupe una camilla
                if (this.cantRevistasOcu < this.cantRevistas) {
                    //El paciente agarra una revista
                    this.cantRevistasOcu++;
                    System.out.println("... " + id + " espera LEYENDO!!");//DEBUG
                    System.out.println("REVISTAS DISPONIBLES [" + (this.cantRevistas - this.cantRevistasOcu) + "/" + this.cantRevistas + "]");
                    
                    try {
                        this.esperaCamilla.await();//Espera
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    this.cantRevistasOcu--;//Deja la revista
                    this.esperaCamillaoRevista.signal();//Notifica a alguien mirando la TV
                } else {
                    //El paciente mira la TV
                    System.out.println(",,, " + id + " espera mirando la TV");//DEBUG
                    
                    try {
                        this.esperaCamillaoRevista.await();//Espera
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            //Camilla disponible
            this.cantCamillasOcu++;
            System.out.println("--> " + id + " OCUPO una camilla!!"); //DEBUG
            
        } finally {
            this.lockCamillas.unlock();//EXM
        }

    }

    public void liberarCamilla(String id) {
        this.lockCamillas.lock();//EXM
        try {
            //Libera una camilla
            this.cantCamillasOcu--;
            System.out.println("<-- " + id + " LIBERO una camilla!!");//DEBUG
            this.esperaCamilla.signal();//Notifica a alguien leyendo una revista
        } finally {
            this.lockCamillas.unlock();//EXM
        }
    }
}
