/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej1;

/**
 *
 * @author KevinDL
 */
class Guitarra extends Instrumento {
    
    public void tocar() {
        System.out.println("Guitarra.tocar()"); 
    }
    
    public String tipo() { return "Guitarra"; }
    
    public void afinar() {}
}
