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
    private int platosReferencia = 5;//Referencia
    private Semaphore platos = new Semaphore(platosReferencia);
    //
    private Semaphore gatoPuedeComer;//Lista de espera
    private Semaphore perroPuedeComer;//Lista de espera
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
    
    }
    
    public void comer(String id){
        
        
        
        
        
        
    }
}
