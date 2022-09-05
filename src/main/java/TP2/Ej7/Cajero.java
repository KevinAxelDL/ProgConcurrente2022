/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej7;

/**
 *
 * @author KevinDL
 */
public class Cajero implements Runnable{
    private long tiempoInicial = 0, tUltimaEjecucion = 0;
    private String nombre;
    private Cliente cteTemporal;
    
    //Contructor
    public Cajero(String nombre, Cliente cte){
        this.nombre = nombre;
        this.cteTemporal = cte;
    }
    //
    private void procesarCompra(){
        System.out.println("El cajero "+ this.nombre +" COMIENZA A PROCESAR"
                + " LA COMPRA DE "+ this.cteTemporal + " EN EL TIEMPO: "
        + (System.currentTimeMillis() - this.tiempoInicial)/1000 + "seg");
        //
        int[] carro = this.cteTemporal.getCarroCompra();
        for(int i = 0; i < carro.length; i++){
            this.esperarXsegundos(carro[i]);
            System.out.println("Procesando el producto "+ (i + 1) +
                    "--> Tiempo: " + (System.currentTimeMillis() - this.tiempoInicial)/
                            1000 + "seg");
        }
        //
        this.tUltimaEjecucion = System.currentTimeMillis() - this.tiempoInicial;
        System.out.println("El cajero "+ this.nombre +" HA TERMINADO DE PROCESAR "
        + this.cteTemporal.getNombre() + 
                " EN EL TIEMPO: "+ this.tUltimaEjecucion/1000 + "seg");
    }
    
    private void esperarXsegundos(int i){
        //Simula el tiempo de procesamiento de un producto
        int tiempo = 500;
        
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException e){
            e.getMessage();
        }
    }
    
    public long getTiempoUltimaEjecucion(){
        return this.tUltimaEjecucion;
    }
    
    public void run(){
        //Codigo a ejecutar por el hilo
        //Tiempo inicial de referencia
        this.tiempoInicial = System.currentTimeMillis();
        this.procesarCompra();
        //FIN RUN
    }
}
