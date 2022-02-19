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
public class Canibal extends Thread{
    private Olla Olla;

    public Canibal( Olla Olla ) {
        // Mantiene una copia propia del objeto compartido
        this.Olla = Olla;
        }

    public void run() {
        while(true){
            Olla.comer();
            // Espera un poco antes de comer mas
            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));

                //sleep( (int)(Math.random() * 1000 ) );
            } 
            catch( InterruptedException e ) {
            }
        }

        }
   // }
}
