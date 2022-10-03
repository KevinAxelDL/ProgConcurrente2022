/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KevinDL
 */
public class Mesa {
    private Semaphore semEspacioMesa = new Semaphore(1);
    private Semaphore semHayCliente = new Semaphore(0);
    private Semaphore semComidaLista = new Semaphore(0);
    
    //Cliente
    
    public void ocuparMesa(String id){
        System.out.println("(---) "+ id +" esperando mesa");
        try{
            this.semEspacioMesa.acquire();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(-->) "+ id +" ocupa la mesa");
    }
    
    public void notificarMozo(String id){
        this.semHayCliente.release();
    }
    
    public void comer(String id){
        System.out.println("(-|-) "+ id +" hace pedido y espera");
        try{
            this.semComidaLista.acquire();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(!!!) "+ id +" come");
    }
    
    public void liberarMesa(String id){
        System.out.println("(<--) "+ id +" libera la mesa");
        this.semEspacioMesa.release();
    }
    
    //Mozo
    
    public void esperarCliente(String id){
        System.out.println("(...) "+ id +" espera un cliente");
        try{
            this.semHayCliente.acquire();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("(<-A) "+ id +" atiende al cliente");
    }
    
    public void servirComida(String id){
        System.out.println("(LI!) "+ id +" comida lista!");
        this.semComidaLista.release();
    }
}


