/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Canibal implements Runnable {

    private String id;
    private Olla olla;

    public Canibal(String id, Olla olla) {
        this.id = id;
        this.olla = olla;
    }

    public void run() {
        while (true) {
            this.olla.tomarRacion(id);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Canibal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
