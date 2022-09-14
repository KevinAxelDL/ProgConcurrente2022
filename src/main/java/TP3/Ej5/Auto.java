/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej5;

/**
 *
 * @author KevinDL
 */
public class Auto extends Vehiculo {

    //Hilo
    public Auto(String id, String modelo, Surtidor[] colSurtidores) {
        super(id, modelo, colSurtidores); //Usa el constructor de la super
        super.consumoXKm = 5;
        super.capacidadLitros = 50;
        super.capacidadLitrosActual = super.capacidadLitros;
    }
    
    public void manejar(){
        //Se utiliza el vehiculo hasta que el nivel de compustible sea critico
        
    }
    
    public int surtidorDisponible(){
        //Verifica si hay algun surtidor en condiciones de ser usado
        int disponible = -1;
        int i=0; //Iterador
        while(disponible == -1 && i < this.colSurtidores.length){
            if(this.colSurtidores[i].getDisponible()){
                //Surtidor en i disponible
                disponible = i;
            }
        }
        return disponible;
    }
    
    public void llenarTanque(int surtidor){
        //Se utiliza el surtidor para llenar el tanque
        colSurtidores[surtidor].llenarTanqueDe(this);
    }

    public void run() {
        boolean accion = true;
        while (accion) {
            manejar();
            int disponible = surtidorDisponible();
            if(disponible != -1){
                //Surtidores disponibles
                llenarTanque(disponible);
            }else{
                //No hay surtidores disponibles
                System.out.println("(X) NO hay mas surtidores disponibles,"+ super.id +" varado");//DEBUG
                accion = false;
            }
        }
    }
}
