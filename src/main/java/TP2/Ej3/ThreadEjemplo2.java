/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej3;

/**
 *
 * @author KevinDL
 */
public class ThreadEjemplo2 implements Runnable{
    //Implementacion mediante interfaz
    String id;
    public ThreadEjemplo2 (String str){
        this.id = str;
    }
    public String getName(){
        return this.id;
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i+" "+ this.id);
            System.out.println("Termina thread "+ this.id);
        }
    }
}
