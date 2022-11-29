/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.BufferOscilante;

/**
 *
 * @author KevinDL
 */
public class Extractor implements Runnable{
    private BufferOscilante buffer;
    
    public Extractor(BufferOscilante buffer){
        this.buffer = buffer;
    }

    public void run() {
        this.buffer.extraer();
    }
}
