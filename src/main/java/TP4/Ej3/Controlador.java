/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KevinDL
 */
public class Controlador {
    /*
    Orden de ejecucion:
    P1 -> P3 -> P2
    */
    protected Semaphore sem1;
    protected Semaphore sem2;
    protected Semaphore sem3;
    
    public Controlador(){
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
        this.sem3 = new Semaphore(0);
    }
    
    
}
