/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej3;

import Herramientas.GeneradorHilos;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("---INICIO MAIN---");
        
        Controlador con = new Controlador();

        P1 obj1 = new P1("P1", con);
        P2 obj2 = new P2("P2", con);
        P3 obj3 = new P3("P3", con);

        Thread t1 = GeneradorHilos.generarHilo(obj1);
        Thread t2 = GeneradorHilos.generarHilo(obj2);
        Thread t3 = GeneradorHilos.generarHilo(obj3);
        
        t1.start();
        t2.start();
        t3.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("---FIN MAIN---");
    }
}
