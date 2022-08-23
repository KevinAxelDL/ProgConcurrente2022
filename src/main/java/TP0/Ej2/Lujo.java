/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

/**
 *
 * @author KevinDL
 */
public class Lujo extends Barco{
    
    private int potenciaCV;
    private int cantCamarotes;
    
    public Lujo(){
        super.matricula = "LUJ-" + Integer.toString((int)(Math.random()*999));
        super.esloraMetros = (25 - (int)(Math.random()*15));
        super.anioFabricacion = (2020 - (int)(Math.random()*50));
        this.potenciaCV = (600 - (int)(Math.random()*500));
        this.cantCamarotes = (10 - (int)(Math.random()*9));
    }
}
