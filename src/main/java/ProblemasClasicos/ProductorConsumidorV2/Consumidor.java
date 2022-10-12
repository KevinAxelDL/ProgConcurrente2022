/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemasClasicos.ProductorConsumidorV2;

import ProblemasClasicos.ProductorConsumidorV1.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin.dittler
 */
public class Consumidor implements Runnable{
    //Obj.Activo
    private String id;
    private Buffer buffer;
    
    public void run(){
        while(true){
            System.out.println("(...) "+ this.id +" produce ...");//DEBUG
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            this.buffer.agregar(id);//Agrega producto de ser posible
        }
    }
    
}
