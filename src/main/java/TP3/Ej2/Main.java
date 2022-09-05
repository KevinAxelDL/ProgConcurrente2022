/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej2;

/**
 *
 * @author KevinDL
 */

/*
EJERCICIO:
Realice un programa en donde se muestre el comportamiento de dos personajes que
alteran nuestro puntos de VIDA (recurso compartido) que se inicializa con 10, de la
siguiente manera:
El Orco (hilo 1) nos golpea quitándonos (-) 3 de VIDA.
El Curandero (hilo 2) nos cura dándonos (+) 3 de VIDA.
Debe tener en cuenta que las operaciones son: obtener VIDA, operarlo y volverlo a
guardar.
*/
public class Main {
    public static void main(String args[]){
        System.out.println("---INICIO MAIN---");
        Thread[] arrHilos = new Thread[2];
        int ataque = 3;
        int curacion = 3;
        int vida = 10;
        //
        Vida vida1 = new Vida(vida);
        Orco orco1 = new Orco(ataque, vida1);
        Curandero cura1 = new Curandero(curacion, vida1);
        //
        Thread t1 = new Thread(orco1);
        Thread t2 = new Thread(cura1);
        arrHilos[0] = t1;
        arrHilos[1] = t2;
        t1.start();
        t2.start();
        //
        try{
            for(int i=0; i<arrHilos.length; i++){
            arrHilos[i].join();
        }
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("---FIN MAIN---");
    }
}
