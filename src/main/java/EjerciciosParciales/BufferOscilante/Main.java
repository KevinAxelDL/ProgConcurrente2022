/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosParciales.BufferOscilante;

import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {
    public static void main(String[] args) {
        BufferOscilante buffer = new BufferOscilante();
        GeneradorIds genIdIn = new GeneradorIds("INSERTOR");
        GeneradorIds genIdEx = new GeneradorIds("EXTRACTOR");
        
        for(int i = 0; i <= 5; i++){
            //Insertores
            Insertor in = new Insertor(buffer, 1);
            Thread t = new Thread(in);
            t.start();
        }
        
        for(int i = 0; i <= 5; i++){
            //Extractores
            Extractor ex = new Extractor(buffer);
            Thread t = new Thread(ex);
            t.start();
        }
    }
}
