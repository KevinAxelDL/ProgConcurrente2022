/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ej5;

/**
 *
 * @author KevinDL
 */
public class Surtidor {

    //Rec. compartido
    private String id;
    private int capacidadLitros;
    private int capacidadLitrosActual;

    public Surtidor(String id) {
        this.id = id;
        this.capacidadLitros = 50;//Modificable
        this.capacidadLitrosActual = this.capacidadLitros;
    }

    public synchronized boolean llenarTanqueDe(Vehiculo auto) {
        //Para mejorar: Evitar el acceso directo a los atributos de Auto sin perder su herencia.
        //Para mejorar: Como sincronizar sin la necesidad de tener el sleep() dentro del metodo?
        //Seccion critica
        boolean cargo = false;
        if (this.capacidadLitrosActual > 0) {
            //Combustible disponible
            System.out.println("(---) " + auto.getId() + " intenta llenar su tanque en " + this.id);//DEBUG
            int litrosRequeridos = auto.capacidadLitros - auto.capacidadLitrosActual;
            int restante = this.capacidadLitrosActual - litrosRequeridos;
            if (restante < 1) {
                //No hay suficientes litros en el surtidor, se carga lo posible
                litrosRequeridos = litrosRequeridos + restante;
                this.capacidadLitrosActual = 0;//Surtidor vacio
            } else {
                this.capacidadLitrosActual = this.capacidadLitrosActual - litrosRequeridos;
            }
            auto.capacidadLitrosActual = auto.capacidadLitrosActual + litrosRequeridos;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }

            System.out.println("(E!!) " + auto.getId() + " tiene (" + auto.capacidadLitrosActual + "/" + auto.capacidadLitros + ") litros en el tanque, se retira de " + this.id);//DEBUG
            System.out.println("(???) " + this.id + " tiene (" + this.capacidadLitrosActual + "/" + this.capacidadLitros + ") litros restantes");//DEBUG
            cargo = true;
        }
        return cargo;
    }

    public String getId() {
        return id;
    }

}
