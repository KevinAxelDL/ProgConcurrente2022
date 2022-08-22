/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1.Ej6;

/**
 *
 * @author KevinDL
 */
public class main {

    public static double acceso_por_indice(double[] v, int j) throws RuntimeException {
        //El metodo esta tomando la excepcion con un "catch" y en vez de tratarla
        //en el mismo delega la responsabilidad con "throws" a otro metodo.
        //No tiene sentido la accion:
        //No es necesario un "throws" si tiene un "catch" para la misma excepcion
        //y no es necesario un "catch" si tiene un "throws" para la misma excepcion
        try {
            if ((0 <= j) && (j <= v.length)) {
                return v[j];
            } else {
                throw new RuntimeException("[EXC!]El indice " + j + " no existe en el vector");
            }
        } catch (RuntimeException exc) {
            throw exc;
        }
    }
    
    public static double acceso_por_indiceV1(double[] v, int j){
        //Este metodo seria una forma CORRECTA de tratar la excepcion
        //Se trata la excepcion en el "catch"
        try {
            if ((0 <= j) && (j <= v.length)) {
                return v[j];
            } else {
                throw new RuntimeException("[EXC!]El indice " + j + " no existe en el vector");
            }
        } catch (RuntimeException exc) {
            System.out.println(exc.getMessage());
        }
        return 0;
    }
    
// Desde el siguiente cliente “main”:

    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indiceV1(v, 16);
    }

}
