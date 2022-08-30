/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej6;

/**
 *
 * @author KevinDL
 */
public class Cajero implements Runnable{
    private String nombre;
    //Contructor
    public Cajero(String nombre){
        this.nombre = nombre;
    }
    //
    public void procesarCompra(Cliente cliente, long timeStamp){
        
        System.out.println("El cajero "+ this.nombre +" COMIENZA A PROCESAR"
                + " LA COMPRA DE "+ cliente.getNombre() + " EN EL TIEMPO: "
        + (System.currentTimeMillis() - timeStamp)/1000 + "seg");
        //
        for(int i = 0; i < cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto "+ (i + 1) +
                    "--> Tiempo: " + (System.currentTimeMillis() - timeStamp)/
                            1000 + "seg");
        }
        //
        System.out.println("El cajero "+ this.nombre +" HA TERMINADO DE PROCESAR "
        + cliente.getNombre() + " EN EL TIEMPO: "+ (System.currentTimeMillis() - 
                timeStamp)/1000 + "seg");
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
    
    public void run(){
        
    }
}
