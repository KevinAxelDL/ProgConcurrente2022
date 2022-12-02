/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.LobosYCorderos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */
public class Rio {

    //Obj.Pasivo
    private ReentrantLock lockRioEntrada = new ReentrantLock();
    private ReentrantLock lockRioSalida = new ReentrantLock();
    private ReentrantLock lockMutex = new ReentrantLock();
    private ReentrantLock lockRioEntradaLobo = new ReentrantLock();//Perinte una ejecucion mas justa
    private Condition esperaRioEntradaLobo =lockRioEntradaLobo.newCondition();
    private Condition esperaRioEntrada = lockRioEntrada.newCondition();
    private Condition esperaRioSalida = lockRioSalida.newCondition();
    //
    private int cantLobosRio = 0;
    private int cantCorderosRio = 0;
    private int cantCorderosEntrada = 0;

    //Metodos para Lobo
    public void entrarLobo(String id) {
        lockRioEntrada.lock();//EXM
        lockRioSalida.lock();//EXM
        
        lockRioEntradaLobo.lock();

        lockMutex.lock();//EXM
        cantLobosRio++;//Entro al rio
        stringEntrar(id);//DEBUG
        lockMutex.unlock();//EXM

        esperaRioEntrada.signalAll();//Notifica que esta en el rio
        esperaRioSalida.signalAll();//Notifica que esta en el rio

        lockRioEntrada.unlock();//EXM
        lockRioSalida.unlock();//EXM
    }

    public void salirLobo(String id) {
        lockRioEntrada.lock();//EXM
        lockRioSalida.lock();//EXM

        lockMutex.lock();//EXM
        cantLobosRio--;
        stringSalir(id);//DEBUG
        lockMutex.unlock();//EXM

        esperaRioEntrada.signalAll();//Notifica que NO esta en el rio
        esperaRioSalida.signalAll();//Notifica que NO esta en el rio

        lockRioEntrada.unlock();//EXM
        lockRioSalida.unlock();//EXM
    }

    //Metodos para Cordero
    public void entrarCordero(String id) {
        lockRioEntrada.lock();//EXM

        lockMutex.lock();//EXM
        this.cantCorderosEntrada++;//Se suma a la lista de espera
        this.esperaRioEntrada.signalAll();//Notifica a todos que esta esperando
        while(!puedeBeber()){
            //No se cumplen las condiciones para poder entrar al rio
            try {
                this.lockMutex.unlock();//EXM
                this.esperaRioEntrada.await();
                lockMutex.lock();//EXM
            } catch (InterruptedException ex) {
                Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.cantCorderosEntrada--;
        this.cantCorderosRio++;//Entra al rio
        
        stringEntrar(id);//DEBUG
        
        if(0 <(this.cantCorderosRio - this.cantLobosRio)){
            //Suficientes corderos, se libera el lock a los lobos
            this.lockRioEntradaLobo.unlock();
        }else{
            this.esperaRioEntrada.signalAll();//Notifica a todos que entro al rio
        }
        
        lockMutex.unlock();//EXM
        
        lockRioEntrada.unlock();//EXM
    }
    
    public void salirCordero(String id){
        lockRioSalida.lock();//EXM

        lockMutex.lock();//EXM
        this.esperaRioSalida.signalAll();//Notifica a todos que esta esperando para salir
        while(!puedeSalir()){
            //No se cumplen las condiciones para poder salir
            try {
                this.lockMutex.unlock();//EXM
                this.esperaRioSalida.await();
                lockMutex.lock();//EXM
            } catch (InterruptedException ex) {
                Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.cantCorderosRio--;//Sale del rio
        
        stringSalir(id);//DEBUG
        
        this.esperaRioSalida.signalAll();//Notifica a todos que salio del rio
        lockMutex.unlock();//EXM
        
        lockRioSalida.unlock();//EXM
        
        
    }

    //Metodos genericos
    private boolean puedeBeber() {
        //Determina si un cordero puede entrar al rio o no dada la situacion
        boolean puedeBeber = false;
        int condicion1 = (this.cantCorderosRio + 1) - this.cantLobosRio;
        int condicion2 = (this.cantCorderosEntrada + 1) - this.cantLobosRio;
        if(condicion1 > 0){
            //Ya hay corderos en el rio, suficientes como para poder entrar
            puedeBeber = true;
        }else{
            if(condicion2 > 0){
                //No hay corderos en el rio
                //Entraran suficientes corderos al rio juntos
                puedeBeber = true;
            }
        }
        return puedeBeber;
    }
    
    private boolean puedeSalir() {
        //Determina si un cordero puede salir al rio o no dada la situacion
        boolean puedeSalir = false;
        int condicion1 = (this.cantCorderosRio - 1) - this.cantLobosRio;
        int condicion2 = this.cantCorderosRio;
        if(condicion1 > 0){
            //Hay suficientes corderos bebiendo como para poder irse
            puedeSalir = true;
        }else{
            if(condicion2 == 0){
                //No hay nadie bebiendo, no hay peligro, se pude ir
                puedeSalir = true;
            }
        }
        return puedeSalir;
    }
    
    private void stringSalir(String id){
        System.out.println(id + " SALIO del rio");//DEBUG
        System.out.println("CANT.LOBOS EN EL RIO: " + this.cantLobosRio);//DEBUG
        System.out.println("CANT.CORDEROS EN EL RIO: " + this.cantCorderosRio);//DEBUG
        System.out.println("---");//DEBUG
    }
    
    private void stringEntrar(String id){
        System.out.println(id + " ENTRO del rio");//DEBUG
        System.out.println("CANT.LOBOS EN EL RIO: " + this.cantLobosRio);//DEBUG
        System.out.println("CANT.CORDEROS EN EL RIO: " + this.cantCorderosRio);//DEBUG
        System.out.println("---");//DEBUG
    }

    /*
    NOTAS:
    + El lobo debe tomar todos los permimisos para salir y entrar al rio
    ya que el accionar de los corderos depende de cuantos lobos allan en el rio
    
    + Por cada lobo deben haber 2 corderos en el rio
    
    + Puede haber mas de un lobo en el rio
    
    + Si al momento de irse un lobo no hay 2 corderos por lobo pasan cosas malas
    */
}
