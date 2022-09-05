/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej2;

/**
 *
 * @author KevinDL
 */
public class Orco implements Runnable {

    //Hilo
    private int puntosAtaque;
    private String id;
    private static int REGISTRO_ID = 0;
    private Vida objetivo;

    public Orco(int pAtaque, Vida objetivo) {
        this.puntosAtaque = pAtaque;
        this.id = generarId();
        this.objetivo = objetivo;
    }

    private synchronized String generarId() {
        //Genera un id para la instancia
        String nuevoId;

        nuevoId = "ORCO-" + Orco.REGISTRO_ID;
        Orco.REGISTRO_ID++;
        return nuevoId;
    }

    public void atacar() {
        //Ataca al objetivo que tiene asignado
        this.objetivo.restarPuntos(this.puntosAtaque);
    }

    public void run() {
        boolean accionar = true;

        while (accionar) {
            if (this.objetivo.getPuntosVida() > 0) {
                System.out.println("(-) " + this.id + " ATACA A " + this.objetivo.getId() + " POR " + this.puntosAtaque + " PUNTOS");
                this.objetivo.restarPuntos(this.puntosAtaque);
                System.out.println("(!) " + this.objetivo.getId() + " TIENE " + this.objetivo.getPuntosVida() + " PUNTOS DE VIDA");
                try {
                    //Tiempo de espera antes del siguiente ataque
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                accionar = false;
                System.out.println("(!!!) OBJETIVO " + this.objetivo.getId() + " DERROTADO!");
            }
        }
    }

}
