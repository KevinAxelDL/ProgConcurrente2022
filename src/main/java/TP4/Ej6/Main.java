/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej6;

/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa();
        Cliente cliente1 = new Cliente("CLIENTE-1", mesa1);
        Cliente cliente2 = new Cliente("CLIENTE-2", mesa1);
        Mozo mozo1 = new Mozo("MOZO-1", mesa1);
        
        Thread t1 = new Thread(cliente1);
        Thread t2 = new Thread(cliente2);
        Thread t3 = new Thread(mozo1);
        
        t1.start();
        t2.start();
        t3.start();
    }
}
