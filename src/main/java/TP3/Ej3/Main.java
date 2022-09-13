/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej3;

import java.util.ArrayDeque;
import Herramientas.GeneradorHilos;
import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---INICIO MAIN---");
        ArrayDeque<Integer> pedidos = new ArrayDeque();//Cola dinamica no sincronizada
        
        //Se crea el arreglo con asientos
        int cantAsientos = 5; //Cant. asientos
        GeneradorIds genIdA = new GeneradorIds("ASIENTO");//Plantilla para Ids
        Asiento[] asientos = new Asiento[cantAsientos];
        
        for(int i=0; i < asientos.length; i++){
            asientos[i] = new Asiento(genIdA.generarUnId());
        }
        
        //Se llena la cola de pedios de asientos
        int n = 10; //Cant. pedidos
        for(int i=0; i < n; i++){
            pedidos.add((int)(Math.random()*(cantAsientos-1)));
        }
        
        //Se crean los hilos y se inicializan
        int m = 2; //Hilos deseados
        Thread[] coleccionHilos = new Thread[m];//Referencias a hilos
        GeneradorIds genIdH = new GeneradorIds("ENCARGADO");//Plantilla para Ids
        
        for(int i=0; i<m; i++){
            Encargado encargado = new Encargado(asientos, genIdH.generarUnId(),pedidos);
            Thread t = GeneradorHilos.generarHilo(encargado);
            coleccionHilos[i] = t;
            t.start();
        }
        
        //Join
        try{
            for(int i=0; i<coleccionHilos.length; i++){
                coleccionHilos[i].join();
            }
        }catch(InterruptedException e){
            e.getMessage();
        }
        System.out.println("---FIN MAIN---");
    }
}
