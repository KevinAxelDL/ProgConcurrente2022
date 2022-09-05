/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2.Ej6;

/**
 *
 * @author KevinDL
 */
public class Cliente{
    private String nombre;
    private int[] carroCompra;
    //Constructor y metodos de acceso
    public Cliente(String nombre, int[] carro){
        this.nombre = nombre;
        this.carroCompra = carro;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }
}
