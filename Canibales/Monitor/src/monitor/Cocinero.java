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
public class Cocinero extends Thread{
    private Olla Olla;

    public Cocinero( Olla o ) {
        // Mantiene una copia propia del objeto compartido
        this.Olla=o;
        }

    public void run() {
        while(true){//CLAVE PARA Q HAGA PA SIEMPRE
            Olla.cocinar();
            // Espera un poco antes de cocinar mas mas
            try {
                //sleep( (int)(Math.random() * 100 ) );
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));

            } 
            catch( InterruptedException e ) {
            }
        }
    }
}
