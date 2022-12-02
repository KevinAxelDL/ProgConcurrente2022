/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.LobosYCorderos;

import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        GeneradorIds genIdLob = new GeneradorIds("LOBO");
        GeneradorIds genIdCor = new GeneradorIds("CORDERO");
        Rio rio = new Rio();
        
        for(int i=0 ;i<5 ; i++){
            Lobo l = new Lobo(genIdLob.generarUnId(), rio);
            Thread t = new Thread(l);
            t.start();
        }
        
        for(int i=0 ;i<5 ; i++){
            Cordero c = new Cordero(genIdCor.generarUnId(), rio);
            Thread t = new Thread(c);
            t.start();
        }
        
    }
}
