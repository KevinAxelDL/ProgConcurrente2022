/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej6;

/**
 *
 * @author KevinDL
 */
public class Cliente implements Runnable{
    private String id;
    private Mesa mesa;
    
    public Cliente(String id, Mesa mesa){
        this.id = id;
        this.mesa = mesa;
    }
    
    public void run(){
        while(true){
            mesa.ocuparMesa(id);
            mesa.notificarMozo(id);
            mesa.comer(id);
            
            try{
                Thread.sleep(1);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            mesa.liberarMesa(id);
        }
    }
}
