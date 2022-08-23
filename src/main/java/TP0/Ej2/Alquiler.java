/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP0.Ej2;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author KevinDL
 */
public class Alquiler {
    
    private Cliente unCliente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int nroAmarre;
    private Barco unBarco;
    
    public Alquiler(Cliente unCliente, int dias, Barco unBarco){
        this.nroAmarre = (int)(Math.random()*50);
        this.unCliente = unCliente;
        this.fechaInicial = LocalDate.now();
        this.fechaFinal = this.fechaInicial.plusDays(dias);
    }
    
}
