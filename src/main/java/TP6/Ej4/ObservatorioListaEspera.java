/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class ObservatorioListaEspera {

    //Monitor
    private int capacidadMax = 5;
    private int capacidadAct = 0;
    //
    private int cantVisitantes = 0;
    private int cantMantenimiento = 0;
    private int cantInvestigadores = 0;
    //

    public ObservatorioListaEspera() {

    }

    //Metodos genericos
    //
    //Metodos para Visitante
    public synchronized void entrarVi(String id) {
        while (this.capacidadAct >= this.capacidadMax || this.cantInvestigadores > 0 || this.cantMantenimiento > 0) {
            //No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        this.cantVisitantes++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO [" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirVi(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.cantVisitantes--;
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    
    //Metodos para Investigador
    public synchronized void entrarIn(String id) {
        while (this.capacidadAct >= this.capacidadMax || this.cantMantenimiento > 0 || this.cantVisitantes > 0 || this.cantInvestigadores > 0) {
            
//No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        this.cantInvestigadores++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO DISPONIBLE[" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirIn(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.cantInvestigadores--;
        this.notifyAll();//Notifica a otros que pueden entrar
    }
    
    
    //Metodos para Mantenimiento
    public synchronized void entrarMa(String id) {
        while ((this.capacidadAct >= this.capacidadMax || this.cantVisitantes > 0 || this.cantInvestigadores > 0)) {
            //No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        this.cantMantenimiento++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO DISPONIBLE[" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirMa(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.cantMantenimiento--;
        this.notifyAll();//Notifica a otros que pueden entrar
    }

}
