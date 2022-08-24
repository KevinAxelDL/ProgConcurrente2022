/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej3;

/**
 *
 * @author KevinDL
 */
public class ThreadEjemplo1 extends Thread{
    //Implementacion mediante extension
    public ThreadEjemplo1 (String str){
        super(str);
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i+" "+ getName());
            System.out.println("Termina thread "+ getName());
        }
    }
}
