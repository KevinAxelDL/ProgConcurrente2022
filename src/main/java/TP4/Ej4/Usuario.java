/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej4;

/**
 *
 * @author KevinDL
 */
public class Usuario {
    private String id;
    private Impresora[] impresoras;
    private char tipoTrabajo;
    
    public Usuario(String id, Impresora[] impresoras){
        this.id = id;
        this.impresoras = impresoras;
    }
}
