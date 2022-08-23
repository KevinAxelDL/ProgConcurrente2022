/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class ThreadTesting {
    /*
    Al ejecutarse el hilo principal, este termina antes 
    que la ejeccion de miHilo si no se realizan cambios al 
    codigo.
    */
    public static void main(String[]args){
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try {
            /*
            El metodo join() permite hacer que el hilo principal
            espere a que finalice la ejecucion de miHilo
            para seguir con su ejecucion.
            En efecto, esto causa que main sea el ultimo metodo
            en terminar de ejecutarse.
            */
            miHilo.join();
        } catch (InterruptedException ex) {
            System.out.println("ERROR: join en main");
        }
        System.out.println("En main");
    }
}
