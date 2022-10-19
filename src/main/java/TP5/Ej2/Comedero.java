/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ej2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Comedero {
    private Semaphore semMutex = new Semaphore(1);//Exlusion mutua
    int permisosGatos = 5;//Referencia
    int permisosPerros = 5;//Referencia
    private Semaphore semPermisosGatos = new Semaphore(permisosGatos);
    private Semaphore semPermisosPerros = new Semaphore(permisosPerros);
    //
    private final int perrosPorTurno = 10;//Cant. minima de perros que comen por turno//Referencia
    private final int gatosPorTurno = 10;//Cant. minima de gatos que comen por turno//Referencia
    private int gatosTurnoActual = this.gatosPorTurno;//Decrementa
    private int perrosTurnoActual = this.perrosPorTurno;//Decrementa
    //
    private boolean perrosEsperando = false;
    private boolean gatosEsperando = false;
    
    public Comedero(){
    }
    
    //Metodos para Perro
    
    private void bloquearGatos(){
        try {
            //Evita que entren gatos a comer
            this.semPermisosGatos.acquire(permisosGatos);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void comer(String id){
        
        
        
        
        
        
    }
}
