/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Pablo
 */
public class Monitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Olla O = new Olla(); //ES EL MONITOR
        Cocinero co = new Cocinero(O); // INSTANCIAMOS COCINERO
        Canibal ca = new Canibal (O);   //INSTANCIAMOS CANIBAL
        ca.start(); //EJECUTAMOS LOS HILOS
        co.start();

        
        
    }
    
}
