/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej4;
import Herramientas.GeneradorIds;
/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        ObservatorioListaEspera lista = new ObservatorioListaEspera();
        GeneradorIds genVis = new GeneradorIds("VISTANTE");
        GeneradorIds genInv = new GeneradorIds("INVESTIGADOR");
        GeneradorIds genMan = new GeneradorIds("MANTENIMIENTO");
        
        for(int i = 0; i < 10; i++){
            //Visitantes
            Visitante v = new Visitante(genVis.generarUnId(),lista);
            Thread t = new Thread(v);
            t.start();
        }
        
        for(int i = 0; i < 5; i++){
            //Mantenimiento
            Visitante v = new Visitante(genMan.generarUnId(),lista);
            Thread t = new Thread(v);
            t.start();
        }
        
        for(int i = 0; i < 10; i++){
            //Investigadores
            Visitante v = new Visitante(genInv.generarUnId(),lista);
            Thread t = new Thread(v);
            t.start();
        }
    }
}
