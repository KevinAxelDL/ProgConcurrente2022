/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ej5;

import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        GeneradorIds genIdAvion = new GeneradorIds("AVION");
        Pista pista = new Pista();
        //
        for (int i = 0; i < 15; i++) {
            Avion a = new Avion(genIdAvion.generarUnId(), pista);
            Thread t = new Thread(a);
            t.start();
        }
    }
}
