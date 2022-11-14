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
    private int permisosVisitante = 5;//DEBUG
    private int permisosInvestigador = 5;//DEBUG
    private int permisosMantenimiento = 5;//DEBUG
    //

    public ObservatorioListaEspera() {

    }

    //Metodos genericos
    //
    //Metodos para Visitante
    public synchronized void entrarVi(String id) {
        while ((this.capacidadAct >= this.capacidadMax || this.permisosVisitante == 0)) {
            //No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO [" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirVi(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.permisosVisitante--;
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    
    //Metodos para Investigador
    public synchronized void entrarIn(String id) {
        while ((this.capacidadAct >= this.capacidadMax || this.permisosVisitante > 0 || this.permisosMantenimiento > 0)) {
            //No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO DISPONIBLE[" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirIn(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.permisosInvestigador--;
        this.permisosMantenimiento = 10;
        this.notifyAll();//Notifica a otros que pueden entrar
    }
    
    
    //Metodos para Mantenimiento
    public synchronized void entrarMa(String id) {
        while ((this.capacidadAct >= this.capacidadMax || this.permisosVisitante > 0)) {
            //No hay espacio en el recinto o no esta habilitado
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservatorioListaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.capacidadAct++;
        System.out.println("--> " + id + " ingreso al recinto");
        System.out.println("ESPACIO DISPONIBLE[" + this.capacidadAct + "/" + this.capacidadMax + "]");
        this.notifyAll();//Notifica a otros que pueden entrar
    }

    public synchronized void salirMa(String id) {
        //Para salir del recinto
        this.capacidadAct--;
        this.permisosMantenimiento--;
        this.permisosInvestigador = 10;
        this.permisosVisitante = 10;
        this.notifyAll();//Notifica a otros que pueden entrar
    }

}
