/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

import Herramientas.GeneradorHilos;
import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        GeneradorIds genPasajero = new GeneradorIds("PASAJERO");
        GeneradorIds genChofer = new GeneradorIds("CHOFER");
        GeneradorIds genTaxi = new GeneradorIds("TAXI");

        Taxi taxi1 = new Taxi(genTaxi.generarUnId());
        Pasajero pas1 = new Pasajero(genPasajero.generarUnId(), taxi1);
        Pasajero pas2 = new Pasajero(genPasajero.generarUnId(), taxi1);
        Chofer chof1 = new Chofer(genChofer.generarUnId(), taxi1);

        Thread t1 = GeneradorHilos.generarHilo(pas1);
        Thread t2 = GeneradorHilos.generarHilo(pas2);
        Thread t3 = GeneradorHilos.generarHilo(chof1);
        
        t1.start();
        t2.start();
        t3.start();
    }
}
