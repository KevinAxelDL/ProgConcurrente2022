/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej3;

/**
 *
 * @author KevinDL
 */
public class main {
    public static void main (String [] args){
        porExtension();
        porInterfaz();
    }
    
    public static void porExtension(){
        //Implementacion de hilos por extension
        ThreadEjemplo1 t1, t2;
        t1 = new ThreadEjemplo1("Maria Jose");
        t2 = new ThreadEjemplo1("Jose Maria");
        //
        t1.start();
        t2.start();
        // 
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("FIN METODO porExtension");
    }
    
    public static void porInterfaz(){
        //Implementacion de hilos mediante interfaz
        Thread t1, t2;
        ThreadEjemplo2 obj1, obj2;
        //
        t1 = new Thread();
        t2 = new Thread();
        //
        
    }
}
