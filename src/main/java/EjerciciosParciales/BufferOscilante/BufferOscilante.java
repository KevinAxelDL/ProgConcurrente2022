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
    private ReentrantLock lockMutex = new ReentrantLock(true);//Exclusion para mensajes
    //
    private LinkedList cola1 = new LinkedList();
    private LinkedList cola2 = new LinkedList();
    private LinkedList colaAux = new LinkedList();//Cola para intercambios
    //

    //Metodos genericos
    public void oscilar() {
        if (this.cola2.isEmpty()) {
            this.lockC1.lock();//EXM-C1
            //Antes de una extraccion
            //Si la cola de extraccion actual esta vacia oscila
            this.colaAux = this.cola1;
            this.cola1 = this.cola2;
            this.cola2 = this.colaAux;
            System.out.println("(CAMBIO DE ETIQUETAS)");//DEBUG
            this.lockC1.unlock();//EXM-C1
        }
    }

    //Metodos para Insertor
    public void insertar(Object obj) {
        this.lockC1.lock();//EXM-C1
        
        this.cola1.add(obj);

        this.lockC2.lock();//EXM-C2
        this.esperaLockC2.signal();//Notifica que se agrego un elemento
        this.lockC2.unlock();//EXM-C2

        this.lockMutex.lock();//EXM-mutex
        System.out.println("INSERCION");//DEBUG
        System.out.println(this.cola1.toString());//DEBUG
        System.out.println(this.cola2.toString());//DEBUG
        System.out.println("----");//DEBUG
        this.lockMutex.unlock();//EXM-mutex

        this.lockC1.unlock();//EXM-C1
    }

    //Metodos para Extractor
    public void extraer() {
        this.lockC2.lock();//EXM-C2
        
        this.oscilar();//Verifica si debe oscilar o no antes de una extraccion

        while (this.cola2.isEmpty()) {
            //Cola vacia, espera a que haya un objeto
            try {
                System.out.println(Thread.currentThread()+"AAAAAA");
                this.esperaLockC2.await();
                this.oscilar();//Verifica si debe oscilar o no antes de una extraccion
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferOscilante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.cola2.remove();
        
        this.lockMutex.lock();//EXM-mutex
        System.out.println("EXTRACCION");//DEBUG
        System.out.println(Thread.currentThread()+" EXTRAE");
        System.out.println(this.cola1.toString());//DEBUG
        System.out.println(this.cola2.toString());//DEBUG
        System.out.println("----");//DEBUG
        this.lockMutex.unlock();//EXM-mutex

        this.lockC2.unlock();//EXM-C2
    }
}
