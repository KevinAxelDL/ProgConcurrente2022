/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

/**
 *
 * @author KevinDL
 */
public class Cliente {
    private String idCliente;
    
    public Cliente(){
        this.idCliente = "CLI-" + (int)(Math.random()*100);
    }
}
