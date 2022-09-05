/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej3;

import java.util.Scanner;

/**
 *
 * @author KevinDL
 */
public class main {

    public static void main(String[] args) {
        //MAIN
        Scanner teclado = new Scanner(System.in);
        int i;

        while (true) {
            System.out.println("[ Ingrese '1'(Extension) o '2'(Interfaz) ]");
            i = teclado.nextInt();
            switch (i) {
                case 1:
                    porExtension();
                    break;
                case 2:
                    porInterfaz();
                    break;
                default:
                    System.out.println("ERROR: Opcion no valida");
            }
        }
    }

    public static void porExtension() {
        //Implementacion de hilos por extension
        ThreadEjemplo1 t1, t2;
        t1 = new ThreadEjemplo1("Maria Jose");
        t2 = new ThreadEjemplo1("Jose Maria");
        //
        t1.start();
        t2.start();
        // 
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("FIN METODO porExtension");
    }

    public static void porInterfaz() {
        //Implementacion de hilos mediante interfaz
        Thread t1, t2;
        ThreadEjemplo2 obj1, obj2;
        //
        obj1 = new ThreadEjemplo2("Maria Jose");
        obj2 = new ThreadEjemplo2("Jose Maria");
        //
        t1 = new Thread(obj1);
        t2 = new Thread(obj2);
        //
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("FIN METODO porIntefaz");
    }
}
