/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej7;
import Herramientas.GeneradorHilos;
/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---INICIO MAIN---");
        //
        Impresora imp1 = new Impresora();
        Simbolo s1 = new Simbolo('A', 1, imp1, 4 );
        Simbolo s2 = new Simbolo('B', 2, imp1, 2 );
        Simbolo s3 = new Simbolo('C', 3, imp1, 5 );
        //
        Thread t1 = GeneradorHilos.generarHilo(s1);
        Thread t2 = GeneradorHilos.generarHilo(s2);
        Thread t3 = GeneradorHilos.generarHilo(s3);
        
        t1.start();
        t2.start();
        t3.start();
        //
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e){
            e.getMessage();
        }
        System.out.println("");
        System.out.println("---FIN MAIN");
    }
}
