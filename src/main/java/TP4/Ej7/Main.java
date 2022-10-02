/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej7;

import Herramientas.GeneradorHilos;
import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        int cantVehNS = 3;
        int cantVehOE = 3;

        GeneradorIds genVeh = new GeneradorIds("VEHICULO");

        GestorCruce gestor = new GestorCruce();

        Controlador controlador = new Controlador(gestor);

        Thread[] colHilos = new Thread[cantVehNS + cantVehOE];
        
        //
        Thread tc = new Thread(controlador);

        for (int i = 0; i < cantVehNS; i++) {
            //Vehiculos NS
            Vehiculo veh = new Vehiculo(genVeh.generarUnId(), gestor, 0);
            colHilos[i] = GeneradorHilos.generarHilo(veh);
        }
        
        for (int i = cantVehNS; i < (cantVehNS + cantVehOE); i++) {
            //Vehiculos OE
            Vehiculo veh = new Vehiculo(genVeh.generarUnId(), gestor, 1);
            colHilos[i] = GeneradorHilos.generarHilo(veh);
        }
        
        //Start
        tc.start();
        for(int i = 0; i < colHilos.length; i++){
            colHilos[i].start();
        }
    }

}
