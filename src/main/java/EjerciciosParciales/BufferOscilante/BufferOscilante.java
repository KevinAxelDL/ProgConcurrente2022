/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.BufferOscilante;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class BufferOscilante {

    private ReentrantLock lockC1 = new ReentrantLock(true);
    private ReentrantLock lockC2 = new ReentrantLock(true);
    private Condition esperaLockC2 = lockC2.newCondition();//Conjunto de espera
    private ReentrantLock lockMutex = new ReentrantLock(true);//Exclusion para consultas y modificaciones que pueden resultar en oscilacion
    //
    private LinkedList cola1 = new LinkedList();
    private LinkedList cola2 = new LinkedList();
    private LinkedList colaAux = new LinkedList();//Cola para intercambios
    //

    //Metodos genericos
    public void oscilar() {
        this.lockMutex.lock();//EXM-mutex
        if (this.cola1.isEmpty() || this.cola2.isEmpty()) {
            //Luego de una extraccion o insercion
            //Si alguna de las 2 colas esta vacia se cambian las etiquetas
            this.colaAux = this.cola1;
            this.cola1 = this.cola2;
            this.cola2 = this.colaAux;
            System.out.println("CAMBIO DE ETIQUETAS");//DEBUG
        }
        this.lockMutex.unlock();//EXM-mutex
    }

    //Metodos para Insertor
    public void insertar(Object obj) {
        this.lockC1.lock();//EXM-C1
        this.lockMutex.lock();//EXM-mutex
        this.cola1.add(obj);

        this.lockC2.lock();//EXM-C2
        this.esperaLockC2.signal();//Notifica que se agrego un elemento
        this.lockC2.unlock();//EXM-C2

        System.out.println("INSERCION");//DEBUG
        System.out.println(this.cola1.toString());//DEBUG
        System.out.println(this.cola2.toString());//DEBUG
        System.out.println("----");//DEBUG

        this.lockMutex.unlock();//EXM-mutex

        this.oscilar();

        this.lockC1.unlock();//EXM-C1
    }

    //Metodos para Extractor
    public void extraer() {
        this.lockC2.lock();//EXM-C2
        this.lockMutex.lock();//EXM-mutex

        while (this.cola2.isEmpty()) {
            //Cola vacia, espera a que haya un objeto
            this.lockMutex.unlock();//EXM-mutex

            try {
                this.esperaLockC2.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferOscilante.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.lockMutex.lock();//EXM-mutex
        }

        this.cola2.remove();

        System.out.println("EXTRACCION");//DEBUG
        System.out.println(this.cola1.toString());//DEBUG
        System.out.println(this.cola2.toString());//DEBUG
        System.out.println("----");//DEBUG

        this.lockMutex.unlock();//EXM-mutex

        this.oscilar();

        this.lockC2.unlock();//EXM-C2
    }
}
