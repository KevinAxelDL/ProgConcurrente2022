/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej1;

/**
 *
 * @author KevinDL
 */
public class testeoRecurso {
    /**
     * En este ejericicio las instancias de Cliente utilizan a Recurso
     * para mostrar un mensaje en pantalla.
     * No es predecible el orden en el que los mensajes se muestran
     */
    public static void main(String[] args){
        Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        juan.start();
        ines.start();
    }
}
