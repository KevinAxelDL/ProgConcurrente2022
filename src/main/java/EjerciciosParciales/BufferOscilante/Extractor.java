/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.BufferOscilante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Extractor implements Runnable {

    private BufferOscilante buffer;
    private int tiempoEspera;

    public Extractor(BufferOscilante buffer) {
        this.buffer = buffer;
        this.tiempoEspera = (int)(Math.random()*6000);
    }

    public void run() {
        try {
            Thread.sleep(tiempoEspera);
        } catch (InterruptedException ex) {
            Logger.getLogger(Extractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.buffer.extraer();

    }
}
