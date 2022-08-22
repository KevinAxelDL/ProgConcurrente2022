/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 *
 * @author KevinDL
 */
public class main {

    public static void main(String args[]) {
        int x = 0;
        int n = 10;
        p(x, n);
    }

    public static void p(int x, int n) {
        //1
        double p;
        try {
            q(x, n);
        } catch (ArithmeticException e) {
            System.out.println("ERROR EN p");
            
        } finally {
            System.out.println("p listo");
        }
    }

    public static void q(int x, int n) {
        //2
        double p;
        try {
            r(x, n);
        } catch (NullPointerException e) {
            System.out.println("ERROR EN q");
        } finally {
            System.out.println("q listo");
        }
    }

    public static void r(int x, int n) {
        //3
        double p;
        double a = 100000;
        int[] arr = new int[n];
        try {
             a = 4 / x;
            for (int i = 0; i <= n; i++) {
                System.out.println("En arreglo");
            }
        }catch(ClassFormatError e){
            System.out.println("ERROR ???");
        }finally{
            System.out.println(a);
        }

    }

}
