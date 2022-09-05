/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej6;

/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args){
        //IMPLEMENTACION MEDIANTE EXTENSION
        System.out.println("--IMPLEMENTACION POR EXTENSION--");
        //Declaracion e inicializacion
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1,3,5,1,1});
        //
        Cajero cajero1 = new Cajero("Cajero 1", cliente1);
        Cajero cajero2 = new Cajero("Cajero 2", cliente2);
        //Start
        cajero1.start();
        cajero2.start();
        //
        try{
            cajero1.join();
            cajero2.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Tiempo de la operacion total: "
                + mayorTiempo(cajero1, cajero2)/1000);
        System.out.println("---FIN MAIN---");
    }
    
    public static long mayorTiempo(Cajero cajero1, Cajero cajero2){
        //Determina cual instancia de Cajero tardo mas en procesar
        long time1 = cajero1.getTiempoUltimaEjecucion();
        long time2 = cajero1.getTiempoUltimaEjecucion();
        if(time1 >= time2){
            return time1;
        }else{
            return time2;
        }
    }
    /**
     * NOTAS:
     * La operacion con 2 clientes y 1 cajero (1  hilo) tarda en promedio 5 seg
     * El contenido de los carros de los clientes son {2,2,1,5,2,3} y {1,3,5,1,1}
     * //
     * La operacion con 2 clientes y 2 cajeros (2  hilos) tarda en promedio 3 seg
     * El contenido de los carros de los clientes son {2,2,1,5,2,3} y {1,3,5,1,1}
     */
}
