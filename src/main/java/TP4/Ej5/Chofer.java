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

    private void esperarCliente() {
        //Simula esperar un cliente
        this.taxi.acquireHayCliente();//Espera
        System.out.println(this.id+ " es avisado que subio alguien");
    }

    private void manejar() {
        //Maneja hasta el destino
        System.out.println(this.id + " maneja a destino ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(this.id + " llego a destino!");
        this.taxi.releaseEnDestino();
    }

    public void run() {
        while (true) {
            esperarCliente();
            manejar();//Cliente a bordo
            this.taxi.releaseEnDestino();//Se baja el cliente
            this.taxi.releaseAsiento();//Se libera el asiento
        }
        
    }
}