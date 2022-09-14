/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej5;

/**
 *
 * @author KevinDL
 */
public class Surtidor {
    //Rec. compartido
    private String id;
    private int capacidadLitros;
    private int capacidadLitrosActual;
    private boolean disponible;
    
    public Surtidor(String id){
        this.capacidadLitros = 500;
        this.capacidadLitrosActual = this.capacidadLitros;
    }

    public synchronized void llenarTanqueDe(Vehiculo auto) {
        //Seccion critica
        System.out.println("(...!)"+ auto.getId() +" esta llenando su tanque en "+ this.id);//DEBUG
        int litrosRequeridos = auto.capacidadLitros - auto.getCapacidadLitrosActual();
        
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.getMessage();
        }
        System.out.println("(!)"+ auto.getId() +" ya lleno el tanque, se retira de "+ this.id);//DEBUG
        System.out.println("(?)"+ this.id +" tiene ("+ this.capacidadLitrosActual +"/"+ this.capacidadLitros +") litros restantes");
    }

    boolean getDisponible() {
        return this.disponible;
    }
    
    
}
