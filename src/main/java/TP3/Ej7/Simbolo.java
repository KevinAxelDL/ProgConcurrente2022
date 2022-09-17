/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej7;

/**
 *
 * @author KevinDL
 */
public class Simbolo implements Runnable{
    private char simbolo;
    private int turno;
    private Impresora impresora;
    private int iteraciones;
    
    public Simbolo(char s, int t, Impresora imp, int i){
        this.simbolo = s;
        this.turno = t;
        this.impresora = imp;
        this.iteraciones = i;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public int getTurno() {
        return turno;
    }
    
    public void run(){
        int cantI = 3;
        int i = 1;
        while(i <= 3){
            //Consulta constantemente si es su turno de imprimir
            if(this.impresora.getTurno() == this.turno){
                //Es su turno de imprimir
                this.impresora.imprimir(this, this.iteraciones);
                i++;
            }
        }
    }
}
