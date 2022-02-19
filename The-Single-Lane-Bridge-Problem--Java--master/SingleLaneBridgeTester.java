import java.util.concurrent.*;

public class SingleLaneBridgeTester 
{
    public static void main(String[] args)
    {
        final Bridge bridge = new Bridge();  //Construimos el puente y creamos un nuevo semaforo.
        Thread South = new Thread(new Runnable()  //Construimos el hilo que representa a los autos del Sur.
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);  //Construimos un nuevo auto y usamos el puente como parametro.
                    Thread a = new Thread(vehicle);  //Usamos al auto como parametro del hilo.
                    vehicle.setName("Auto SUR: "+a.getId());  //Nombramos al auto como Auto SUR y obtiene el ID del hilo.
                    a.start();  //Comienza 
                    try  //try catch 
                    {    //Dormimos al hilo por un tiempo determinado por:
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {  //Excepcion
                        iex.printStackTrace();
                    }
                }
            }
        });
        Thread North = new Thread(new Runnable() //Construimos el hilo que representa a los autos del Norte.
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);  //Construimos un nuevo auto y usamos el puente como parametro.
                    Thread a = new Thread(vehicle);  /Usamos al auto como parametro del hilo.
                    vehicle.setName("North Vehicle:  "+a.getId());  //Nombramos al auto como Auto SUR y obtiene el ID del hilo.
                    a.start();  //Comienza
                    try
                    {   //Dormimos al hilo por un tiempo determinado por:
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {  //Excepcion
                        iex.printStackTrace();        
                    }
                }
            }
        });
        South.start();  
        North.start();  
    }
}
