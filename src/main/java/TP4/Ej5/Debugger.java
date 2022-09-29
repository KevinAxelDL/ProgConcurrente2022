/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej5;

/**
 *
 * @author KevinDL
 */
public abstract class Debugger {
    //Clase con mensajes sincronizados para mostrar por pantalla la ejecucion
    
    public synchronized static void subir(String id){
        System.out.println("(->)"+ id +" subio al taxi");//DEBUG
    }
    
    public synchronized static void hayCliente(String idChof, String idPas){
        System.out.println("(!)"+ idChof+ " es avisado que subio "+ idPas);//DEBUG
    }
    
    public synchronized static void manejar(String idChof, String idPas){
        System.out.println("(...)"+ idChof + " maneja a destino con "+ idPas);//DEBUG
    }
    
    public synchronized static void enDestino(String idChof, String idPas){
        System.out.println("(D!)"+ idChof + " llego a destino de "+ idPas);
        System.out.println("---");
    }
    
    public synchronized static void bajar(String id){
        System.out.println("(<-)"+ id + " baja del taxi");//DEBUG
    }
    
}
