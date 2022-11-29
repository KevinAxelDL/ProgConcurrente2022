/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Olla {
    private Semaphore semRaciones;
    private Semaphore semFaltanRaciones = new Semaphore(0);
    private Semaphore semMutex = new Semaphore(1);
    private boolean avisado = false;
    //
    private int cantRacionesAct = 0;
    private int cantRacionesMax;
    
    public Olla(int maxRaciones){
        this.cantRacionesMax = maxRaciones;
        this.semRaciones = new Semaphore(0,true);
    }
    
    //Metodos para Cocinero
    public void llenarOlla(String id){
        try {
            this.semFaltanRaciones.acquire();
            this.semMutex.acquire();//EXM
            //Se vacio la olla
            System.out.println("!!!) SE ACABARON LAS RACIONES!!!");//DEBUG
            this.cantRacionesAct = this.cantRacionesMax;//Reinicia el contador
            System.out.println("ooo) "+ id +" cocino nuevas raciones");//DEBUG
            this.semRaciones.release(this.cantRacionesMax);//Libera los permisos
            this.avisado = false;
            this.semMutex.release();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodos para Canibal
    public void tomarRacion(String id){
        try {
            this.semMutex.acquire();//EXM
            if(this.cantRacionesAct == 0 && !avisado){
                //Faltan raciones, notifica
                this.semFaltanRaciones.release();
                this.avisado = true;
            }
            this.semMutex.release();//EXM
            
            this.semRaciones.acquire();//Toma una racion        
            
            this.semMutex.acquire();//EXM
            this.cantRacionesAct--;//Modifica el contador
            System.out.println("<--) "+ id +" tomo una racion");//DEBUG
            System.out.println("RACIONES DISPONIBLES: ["+ cantRacionesAct + "/" + this.cantRacionesMax +"]");//DEBUG
            this.semMutex.release();//EXM
        } catch (InterruptedException ex) {
            Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
