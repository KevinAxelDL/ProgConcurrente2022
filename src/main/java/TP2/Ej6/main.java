/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej6;

/**
 *
 * @author KevinDL
 */
public class main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1,3,5,1,1});
        Cajero cajero1 = new Cajero("Cajero 1");
        //Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
        //
        
    }
    
}
