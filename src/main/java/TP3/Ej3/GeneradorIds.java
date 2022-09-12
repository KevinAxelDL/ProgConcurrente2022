/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej3;

/**
 *
 * @author KevinDL
 */
public class GeneradorIds {
    //Clase para generar IDs 
    private int contadorRef;
    private String nombreRef;
    
    public GeneradorIds(String nombre){
        this.nombreRef = nombre.toUpperCase();
        this.contadorRef = 0;
    }
    
    public String generarUnId(){
        return (this.nombreRef+ "-" + Integer.toString(this.contadorRef));
    }
}
