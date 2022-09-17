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
        this.consumoXKm = 5;
        this.capacidadLitros = 50;
        this.capacidadLitrosActual = this.capacidadLitros;
    }

    public void manejar() {
        //Se utiliza el vehiculo hasta que el nivel de compustible sea critico
        boolean critico = false;
        while (!critico) {
            this.capacidadLitrosActual = this.capacidadLitrosActual - this.consumoXKm;
            System.out.println("(-->) " + this.id + " andando; tanque (" + this.capacidadLitrosActual + "/" + this.capacidadLitros + ")L");//DEBUG
            if (this.capacidadLitrosActual <= 10) {
                //Bajo en combustible
                critico = true;
                System.out.println("(!!!) " + this.id + " BAJO EN COMBUSTIBLE!!");//DEBUG
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean surtidorDisponible() {
        //Verifica si hay algun surtidor en condiciones de ser usado y lo usa
        boolean cargo = false;
        int i = 0; //Iterador
        while (!cargo && i < this.colSurtidores.length) {
            System.out.println("(...) "+ this.id +" esperando para llenar el tanque");//DEBUG
            cargo = this.colSurtidores[i].llenarTanqueDe(this);
            
            if(!cargo){
                System.out.println("(--X) " + this.id +" no pudo cargar en "+ this.colSurtidores[i].getId());//DEBUG
            }
            
            i++;
        }
        return cargo;
    }

    public void run() {
        boolean accion = true;
        while (accion) {
            manejar();
            boolean cargo = surtidorDisponible();
            if (!cargo) {
                //No hay surtidores disponibles
                System.out.println("(X) NO hay mas surtidores disponibles, " + super.id + " queda en condicion critica");//DEBUG
                accion = false;
            }
        }
    }
}
