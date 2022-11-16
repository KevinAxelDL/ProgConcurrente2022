/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej7;

import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        int cantRaciones = 5;
        GeneradorIds genIdCan = new GeneradorIds("CANIBAL");
        GeneradorIds genIdCo = new GeneradorIds("COCINERO");
        //
        Olla olla = new Olla(cantRaciones);
        //
        Cocinero co = new Cocinero(genIdCo.generarUnId(), olla);
        Thread t1 = new Thread(co);
        t1.start();
        //
        for(int i = 0; i < 12; i++){
            Canibal ca = new Canibal(genIdCan.generarUnId(), olla);
            Thread t2 = new Thread(ca);
            t2.start();
        }
        
    }
}
