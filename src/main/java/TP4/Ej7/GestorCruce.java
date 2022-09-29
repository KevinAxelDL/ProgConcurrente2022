/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ej7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KevinDL
 */
public class GestorCruce {
    Semaphore semEstOest = new Semaphore(0);
    Semaphore semNorSur = new Semaphore(0);
    
    Semaphore sensorInEstOest = new Semaphore(0);
    Semaphore sensorInNorSur = new Semaphore(0);
    
    Semaphore sensorOutEstOest = new Semaphore(0);
    Semaphore sensorOutNorSur = new Semaphore(0);
}
