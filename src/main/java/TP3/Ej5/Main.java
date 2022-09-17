/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej5;
import Herramientas.GeneradorHilos;
import Herramientas.GeneradorIds;
/**
 *
 * @author KevinDL
 */
public class Main { 
    public static void main(String[] args) {
        System.out.println("---INICIO MAIN---");

        int cantVehiculos = 2;//Modificable
        int cantSurtidores = 1;//Modificable
        
        GeneradorIds genIdAuto, genIdSurtidor;
        genIdAuto = new GeneradorIds("AUTO");//Gen
        genIdSurtidor = new GeneradorIds("SURTIDOR");//Gen
        Thread[] colHilos = new Thread[cantVehiculos];
        Surtidor[] colSurtidores = new Surtidor[cantSurtidores];
        //
        Surtidor surtidor;
        for(int i=0; i < cantSurtidores; i++){
            //Genera col. de surtidores
            surtidor = new Surtidor(genIdSurtidor.generarUnId());
            colSurtidores[i] = surtidor;
        }
        Auto auto;
        Thread t;
        for(int i=0; i < cantVehiculos; i++){
            //Genera col. de autos
            auto = new Auto(genIdAuto.generarUnId(), "SAMPLE", colSurtidores);
            t = GeneradorHilos.generarHilo(auto);
            colHilos[i] = t;
            t.start();
        }
        //
        try{
            for(int i = 0; i < cantVehiculos; i++){
                colHilos[i].join();
            }
        }catch(InterruptedException e){
            e.getMessage();
        }
        System.out.println("---FIN MAIN---");//DEBUG
    }
    /*
    NOTAS:
    + Los bloques sincronizados deberian ir en el recurso compartido
    */
}
