/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej1;

/**
 *
 * @author KevinDL
 */
public class Cliente extends Thread{
    //Implementacion de un hilo mediante extension
    public void run(){
        System.out.println("soy " + Thread.currentThread().getName());
        Recurso.uso();
        try{
            Thread.sleep(2000); //Se bloquea el hilo temporalmente
        }catch(InterruptedException e){            
        }
    }
}
