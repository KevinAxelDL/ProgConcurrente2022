/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej7;

/**
 *
 * @author KevinDL
 */
public class Impresora {
    //Req. compartido
    private int turno;
    private int turnosMax;
    private String id;
    
    public Impresora(){
        this.turno = 1;
        this.id = "IMPRESORA";
        this.turnosMax = 3;
    }
    
    public synchronized void imprimir(Simbolo obj, int iteraciones){
        //Imprime X veces la letra enviada por parametro 
        char s = obj.getSimbolo();
        for(int i = 1; i <= iteraciones; i++){
            System.out.print(s);
        }
        this.turno++;
        if(this.turno > this.turnosMax){
            //Se resetean los turnos
            this.turno = 1;
        }
    }

    public synchronized int getTurno() {
        return turno;
    }

    public int getTurnosMax() {
        return turnosMax;
    }

    public String getId() {
        return id;
    }
    
    
}
