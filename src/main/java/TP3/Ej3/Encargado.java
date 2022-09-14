/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej3;

import java.util.ArrayDeque;

/**
 *
 * @author KevinDL
 */
public class Encargado implements Runnable{
    //Hilo
    private Asiento[] asientos;//Rec Compartido
    private String id;
    private ArrayDeque<Integer> pedidos;//Rec.Compartido
    
    public Encargado(Asiento[] asientos, String id, ArrayDeque pedidos){
        this.asientos = asientos;
        this.id = id;
        this.pedidos = pedidos;
    }
    
    private void reservarAsiento(int asiento){
        //Reserva un asiento segun el parametro
        boolean ocupado;
        ocupado = this.asientos[asiento].ocupar();
        if(ocupado == true){
            System.out.println("(X)ERROR: asiento "+ asiento +" ya ocupado");
        }else{
            System.out.println("(*)EXITO: asiento "+ asiento +" reservado");
        }
    }
    
    private synchronized int tomarPedido(){
        //Toma un pedido de la cola para intentar resolverlo
        int pedido = -1;
        synchronized(this.pedidos){
            //Evita el acceso y modificacion simultanea de la cola
            if(this.pedidos.isEmpty()){
                System.out.println("(X)ERROR: ya no hay mas pedidos por tomar");
            }else{
                pedido = this.pedidos.remove();//Toma y elimina el tope de la cola
                System.out.println("(!)"+ this.id +" a tomado un pedido para "+ Integer.toString(pedido) +" ("+ this.asientos[pedido].getId()+")");
            }
        }
        return pedido;
    }
    
    public void run(){
        while(!this.pedidos.isEmpty()){
            int pedido = tomarPedido();
            if(pedido != -1){
                reservarAsiento(pedido);
            }
        }
    }
}
