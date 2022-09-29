/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej1;

/**
 *
 * @author KevinDL
 */
public class SynchronizedObjectCounter {

    private int c = 0;

    public void increment() {
        synchronized (this) {
            c++;
        } // Este elemento debe ser casteado a Integer
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        synchronized (this){
            return c;
        }
    }
}
