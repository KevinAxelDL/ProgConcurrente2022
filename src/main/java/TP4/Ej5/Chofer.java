/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

/**
 *
 * @author KevinDL
 */
public class Chofer implements Runnable{

    private String id;
    private Taxi taxi;

    public Chofer(String id, Taxi taxi) {
        this.id = id;
        this.taxi = taxi;
    }

    public void run() {
        while (true) {
            taxi.esperarCliente();
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            taxi.notificarEnDestino();
        }
    }
}
