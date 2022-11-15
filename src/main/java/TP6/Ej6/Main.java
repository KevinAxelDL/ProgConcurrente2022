/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ej6;

import Herramientas.GeneradorIds;

/**
 *
 * @author KevinDL
 */
public class Main {

    public static void main(String[] args) {
        GeneradorIds genIdPacientes = new GeneradorIds("PACIENTE");
        CentroHemoterapia centro1 = new CentroHemoterapia();

        for (int i = 0; i < 25; i++) {
            Paciente obj = new Paciente(genIdPacientes.generarUnId(), centro1);
            Thread t = new Thread(obj);
            t.start();
        }
    }
}
