/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.BufferOscilante;

/**
 *
 * @author KevinDL
 */
public class Insertor implements Runnable{
    private BufferOscilante buffer;
    private Object object;
    
    public Insertor(BufferOscilante buffer, Object object){
        this.buffer = buffer;
        this.object = object;
    }
    
    public void run(){
        this.buffer.insertar(this.object);
    }
}
