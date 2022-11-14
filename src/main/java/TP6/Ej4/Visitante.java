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
public class Visitante implements Runnable {

    ObservatorioListaEspera monitor;
    String id;

    public Visitante(String id, ObservatorioListaEspera m) {
        this.id = id;
        this.monitor = m;
    }

    public void run() {
        while (true) {
            this.monitor.entrarVi(id);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.monitor.salirVi(id);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
