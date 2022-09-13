/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

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
        String id = (this.nombreRef+ "-" + Integer.toString(this.contadorRef));
        this.contadorRef++;
        return id;
    }
}
