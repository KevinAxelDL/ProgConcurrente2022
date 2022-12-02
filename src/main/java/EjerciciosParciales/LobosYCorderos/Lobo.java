/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.LobosYCorderos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Lobo implements Runnable{

    private String id;
    private Rio rio;
    private int espera1 = (int) (Math.random() * 5000);

    public Lobo(String id, Rio rio) {
        this.id = id;
        this.rio = rio;
    }

    public void run() {

        try {
            Thread.sleep(espera1);
            this.rio.entrarLobo(id);
            Thread.sleep(espera1);
            this.rio.salirLobo(id);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Lobo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
