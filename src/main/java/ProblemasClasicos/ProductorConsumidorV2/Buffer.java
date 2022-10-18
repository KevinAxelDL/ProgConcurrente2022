/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemasClasicos.ProductorConsumidorV2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author kevin.dittler
 */
public class Buffer {
    //(Para caso 'k' consumidores y 'j' productores)
    //(Puede considerarse similar a los problemas donde se aplica "rendezvous" con sem. binarios)
    
    private Semaphore mutex = new Semaphore(1);//Exclusion mutua (consistencia en la estrucutra)
    private int[] estructura;//Estructura para almacenar productos
    private Semaphore espacioLibre;//Comunicacion con Productor
    private Semaphore espacioOcupado;//Comunicacion con Consumidor

    public Buffer(int espacio) {
        this.estructura = new int[espacio];
        this.espacioLibre = new Semaphore(espacio);
        this.espacioOcupado = new Semaphore(0);
    }

    private void acquireMutex() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodos para Consumidor
    public void consumir(String id) {
        //Consume un producto siempre que hayan disponibles

        try {
            this.espacioOcupado.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        int i = 0;
        
        acquireMutex();//Exclusion mutua
        while (i < this.estructura.length) {   
            if (this.estructura[i] == 1) {
                //Espacio lleno, lo vacia
                this.estructura[i] = 0;
                System.out.println("(<--) "+ id +" quita producto");//DEBUG
                i = this.estructura.length;//Corta la iteracion
            }
            i++;
        }
        mutex.release();
        
        this.espacioLibre.release();//Avisa a Productor
    }

    //Metodos para Productor
    public void agregar(String id) {
        //Agrega productos a la estructura cuando haya espacio

        try {
            this.espacioLibre.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        int i = 0;

        acquireMutex();//Exclusion mutua
        while (i < this.estructura.length) {
            if (this.estructura[i] == 0) {
                //Espacio vacio, lo llena
                this.estructura[i] = 1;
                System.out.println("(-->) "+ id +" agrega producto");//DEBUG
                i = this.estructura.length;//Corta la iteracion
            }
            i++;
        }
        mutex.release();
        
        this.espacioOcupado.release();//Avisa a consumidor
    }
}
