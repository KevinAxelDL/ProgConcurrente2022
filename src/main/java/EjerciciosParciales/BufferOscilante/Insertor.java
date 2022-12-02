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
public class Insertor implements Runnable{
    private BufferOscilante buffer;
    private Object object;
    private int tiempoEspera;
    
    public Insertor(BufferOscilante buffer, Object object){
        this.buffer = buffer;
        this.object = object;
        this.tiempoEspera = (int)(Math.random()*3000);
    }
    
    public void run(){
        try {
            Thread.sleep(tiempoEspera);
        } catch (InterruptedException ex) {
            Logger.getLogger(Insertor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.buffer.insertar(this.object);
    }
}
