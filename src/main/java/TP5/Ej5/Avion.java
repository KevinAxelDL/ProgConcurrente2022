/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ej5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Avion implements Runnable{

    //Obj.Activo
    private String id;
    private Pista pista;

    public Avion(String id, Pista pista) {
        this.id = id;
        this.pista = pista;
    }

    public void run() {
        pista.aterrizar(this.id);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("[.] "+ this.id + " espera en hangar");//DEBUG
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }

        pista.despegar(this.id);
    }
}
