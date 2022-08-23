/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

/**
 *
 * @author KevinDL
 */
public class Barco {
    
    protected String matricula;
    protected int esloraMetros;
    protected int anioFabricacion;
    /**
     * (Los atributos deben tener su visibilidad en protected ( o no en private) 
     * para que las subclases puedan acceder a ellas)
     */
    public Barco(){
        //Constructor
        this.matricula = "BAR-" + Integer.toString((int)(Math.random()*999));
        this.esloraMetros = (int)((Math.random()*25) - (Math.random()*10));
        this.anioFabricacion = (int)((Math.random()*2022) - (Math.random()*1980));
    }
}
