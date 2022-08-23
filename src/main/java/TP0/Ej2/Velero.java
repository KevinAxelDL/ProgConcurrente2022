/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

/**
 *
 * @author KevinDL
 */
public class Velero extends Barco{
    
    private int cantMastiles;
    
    public Velero(int cantMastiles){
        super.matricula = "VEL-" + Integer.toString((int)(Math.random()*999));
        super.esloraMetros = (int)((Math.random()*25) - (Math.random()*10));
        super.anioFabricacion = (int)((Math.random()*2022) - (Math.random()*1980));
        this.cantMastiles = cantMastiles;
    }
    
}
