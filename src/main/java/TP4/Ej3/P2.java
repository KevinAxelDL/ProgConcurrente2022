/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej3;

/**
 *
 * @author KevinDL
 */
public class P2 implements Runnable {

    private String id;
    private Controlador con;

    public P2(String id, Controlador con) {
        this.id = id;
        this.con = con;
    }

    public void run() {
        
        while (true) {

            try {
                this.con.sem2.acquire();;//Intenta adquirir sem2
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(this.id);
            System.out.println("|");

            this.con.sem1.release();//Libera sem1
        }
    }
}
