/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

/**
 *
 * @author KevinDL
 */
public class Deportivo extends Barco{
    
    private int potenciaCV;
    
    public Deportivo(){
        super.matricula = "DEP-" + Integer.toString((int)(Math.random()*999));
        super.esloraMetros = (25 - (int)(Math.random()*15));
        super.anioFabricacion = (2020 - (int)(Math.random()*1980));
        this.potenciaCV = (600 - (int)(Math.random()*500));
    }
}
