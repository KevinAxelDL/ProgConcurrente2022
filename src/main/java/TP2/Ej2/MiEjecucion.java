/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej2;

/**
 *
 * @author KevinDL
 */
public class MiEjecucion extends Thread {
    public void run(){
        ir();
    }
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("En la pila");
    }
}
