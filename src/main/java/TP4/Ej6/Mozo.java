/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej6;

/**
 *
 * @author KevinDL
 */
public class Mozo implements Runnable {

    private String id;
    private Mesa mesa;

    public Mozo(String id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    public void run() {
        while (true) {
            mesa.esperarCliente(id);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            mesa.servirComida(id);
        }
    }
}
