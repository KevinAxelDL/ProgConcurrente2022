/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej7;

/**
 *
 * @author KevinDL
 */
public class Controlador implements Runnable {

    /*
    El Controlador debe cambiar de color los semaforos cada cierto tiempo,
    si un semaforo esta en rojo, desabilita los permisos para que los autos
    puedan cruzar
     */
    private GestorCruce gestorCruce;

    public Controlador(GestorCruce gestor) {
        this.gestorCruce = gestor;
    }

    private void activarOE() {

        //Activa el semaforo por un tiempo especifico
        this.gestorCruce.aVerdeOE();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        //Espera a que termine de pasar el ultimo auto antes de cambiar a rojo
        this.gestorCruce.aRojoOE();
    }

    private void activarNS() {

        //Activa el semaforo por un tiempo especifico
        this.gestorCruce.aVerdeNS();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        //Espera a que termine de pasar el ultimo auto antes de cambiar a rojo
        this.gestorCruce.aRojoNS();
    }

    public void run() {
        while (true) {
            activarOE();
            activarNS();
        }
    }
}
