/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej2;

/**
 *
 * @author KevinDL
 */
public class Vida {
    //Recurso compartido
    private int puntosVida;
    private int puntosVidaMaximos;
    private String id;
    private static int REGISTRO_ID = 0;

    public Vida(int v){
        this.puntosVida = v;
        this.id = generarId();
    }
    
    private synchronized String generarId(){
        //Genera un id para la instancia
        String nuevoId;
        
        nuevoId = "VIDA-"+ Vida.REGISTRO_ID;
        Vida.REGISTRO_ID++;
        return nuevoId;
    }
    
    public synchronized void restarPuntos(int puntosAtaque){
        //Se restan puntos de los puntos de vida totales
        this.puntosVida = this.puntosVida - puntosAtaque;
    }
    
    public synchronized void sumarPuntos(int puntosCuracion){
        //Se suman puntos a los puntos de vida totales
        int nuevaVida = this.puntosVida + puntosCuracion;
        if(nuevaVida >= this.puntosVidaMaximos ){
            //Los puntos de curacion sumados exceden el limite, se suma lo necesario
            nuevaVida = nuevaVida - (nuevaVida - this.puntosVidaMaximos);
        }
        this.puntosVida = nuevaVida;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getId() {
        return id;
    }
    
    
}
