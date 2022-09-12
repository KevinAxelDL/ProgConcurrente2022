/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej3;

/**
 *
 * @author KevinDL
 */
public class Asiento {
    //Rec. compartido
    private String id;
    private int estado; //0 es libre; 1 es ocupado
    
    public Asiento(String id){
        this.id = id;
        this.estado = 0;
    }
    
    public synchronized boolean ocupar(){
        //Se ocupa el asiento si no esta ocupado ya
        boolean ocupado = false;
        
        if(this.estado == 1){
            ocupado = true;
        }
        return ocupado;
    }
}
