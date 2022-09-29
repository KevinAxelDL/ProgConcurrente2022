/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej3;

/**
 *
 * @author KevinDL
 */
public class P3 implements Runnable {

    private String id;
    private Controlador con;

    public P3(String id, Controlador con) {
        this.id = id;
        this.con = con;
    }

    public void run() {

        while (true) {

            try {
                this.con.sem3.acquire();;//Intenta adquirir sem3
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(this.id);
            System.out.println("|");

            this.con.sem2.release();//Libera sem2, da permiso a P2
        }
    }
}
