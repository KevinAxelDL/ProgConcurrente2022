/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej2;

/**
 *
 * @author KevinDL
 */
public class Curandero implements Runnable{
    //Hilo
    private int puntosCuracion;
    private String id;
    private static int REGISTRO_ID = 0;
    private Vida objetivo;
    
    public Curandero(int pCur, Vida objetivo){
        this.puntosCuracion = pCur;
        this.id = generarId();
        this.objetivo = objetivo;
    }
    
    private synchronized String generarId(){
        //Genera un id para la instancia
        String nuevoId;
        
        nuevoId = "CURANDERO-"+ Curandero.REGISTRO_ID;
        Curandero.REGISTRO_ID++;
        return nuevoId;
    }
    
    public void curar(){
        //Cura al objetivo asignado
        this.objetivo.sumarPuntos(this.puntosCuracion);
    }
    
    public void run() {
        boolean accionar = true;

        while (accionar) {
            if (this.objetivo.getPuntosVida() > 0) {
                System.out.println("(+) " + this.id + " CURA A " + this.objetivo.getId() + " POR " + this.puntosCuracion + " PUNTOS");
                this.objetivo.restarPuntos(this.puntosCuracion);
                System.out.println("(!) " + this.objetivo.getId() + " TIENE " + this.objetivo.getPuntosVida() + " PUNTOS DE VIDA");
                try {
                    //Tiempo de espera antes de la siguiente curacion
                    Thread.sleep(590);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                accionar = false;
                System.out.println("(!!!) OBJETIVO " + this.objetivo.getId() + " DERROTADO, NO SE PUEDE CURAR!");
            }
        }
    }
}
