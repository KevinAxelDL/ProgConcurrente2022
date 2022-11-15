/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Paciente implements Runnable {

    private String id;
    private CentroHemoterapia centro;

    public Paciente(String id, CentroHemoterapia centro) {
        this.id = id;
        this.centro = centro;
    }

    public void run() {
        centro.ocuparCamilla(id);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        centro.liberarCamilla(id);
    }
}
