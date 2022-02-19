import java.util.concurrent.*;

public class Bridge 
{
    private final Semaphore sema;  //Creamos el semaforo. 
    
    public Bridge()
    {
        sema = new Semaphore(1);  //Inicializamos el semaforo. Controlamos el acceso .
    }
    
    public void crossBridge(Vehicle vehicle)
    {
        try
        {
            System.out.printf("%s ESPERANDO para cruzar el puente.\n",vehicle.getName()); 
            sema.acquire();  //Acquire es usado cuando se envian senales entre dos hilos. Adquiere un proceso y se bloquea hasta que es liberado.
            System.out.printf("%s CRUZANDO el puente.\n",vehicle.getName());  
            long duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {   //En caso de excepciones
            iex.printStackTrace();
        }
        finally
        {
            System.out.printf("%s TERMINO DE CRUZAR el puente.\n",vehicle.getName());  
            sema.release();  // Se libera el proceso
        }
    }

  
}
