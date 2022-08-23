/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej1;

/**
 *
 * @author KevinDL
 */
public class Recurso {
    static void uso(){
        Thread t = Thread.currentThread(); //Retorna la instancia del hilo en ejecucion actualmente
        System.out.println("en Recurso: Soy "+ t.getName());
    }
}
