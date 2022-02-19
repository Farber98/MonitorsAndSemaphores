/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Pablo
 */
public class Olla {
    private int Olla=10;//LA OLLA TIENE UN MAXIMO DE 10 MISIONEROS
    private boolean estaVacia = true;    
  // METODO PARA COMER MISIONEROS
    public synchronized void comer() {
        // NO SE PUEDE CONSUMIR SI LA OLLA ESTA VACIA

        while( estaVacia == true )//SI LA OLLA ESTA VACIA
            {
            try {
                wait(); // ESPERO
            } catch( InterruptedException e ) {

                }
            }
        // Decrementa la cuenta, ya que va a consumir una comida (OLLA=OLLA-1)
        while(Olla != 0 ){
            Olla--;
            System.out.println( "Canibal comio al misionero numero "+ (Olla+1) );
            try {
                TimeUnit.SECONDS.sleep((long)(1.5));

                //sleep( (int)(Math.random() * 1000 ) );
            } 
            catch( InterruptedException e ) {
            }    
        }
    
        estaVacia = true;
        notify();//Avisa al otro hilo que desocupo el recurso

        }
    
    // Método para añadir MISIONEROS a la olla
    public synchronized void cocinar() {
        // ESPERA HASTA QUE HAYA ESPACIO PARA MAS MISIONEROS
        while( estaVacia == false )
            {
            try {
                wait(); 
            } catch( InterruptedException e ) {
                
                }
            }
        // Añade 10 misioneros a la Olla
        Olla=10;
        System.out.println( "Cocinero cocino 10 misioneros" );
        estaVacia = false;
        notify();//avisa al otro hilo que desocupo el recurso
        }
    
    
}
