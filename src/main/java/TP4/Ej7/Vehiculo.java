/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej7;

/**
 *
 * @author KevinDL
 */
public class Vehiculo implements Runnable {

    /*
    Los Vehiculos avanzan o esperan en base a los sensores del semaforo,
    uno por vez pueden cruzar la interseccion mientras que el semaforo este en
    verde
     */
    private String id;
    private GestorCruce gestor;
    private int calle; // 0 = Norte-Sur, 1 = Oeste-Este

    public Vehiculo(String id, GestorCruce gestor, int calle) {
        this.id = id;
        this.gestor = gestor;
        this.calle = calle;
    }

    private String tipoCalle() {
        String c = null;
        switch (calle) {
            case 0:
                c = "N-S";
                break;
            case 1:
                c = "O-E";
                break;
        }
        return c;
    }

    public void run() {
        
        if(calle == 0){
            this.gestor.llegarNS(this.id);//Espera el semaforo y cruza
            
        }else{
            this.gestor.llegarOE(this.id);//Espera el semaforo y cruza
        }
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if(calle == 0){
            this.gestor.salirNS(this.id);//Sale
            
        }else{
            this.gestor.salirOE(this.id);//Sale
        }
    }
}
