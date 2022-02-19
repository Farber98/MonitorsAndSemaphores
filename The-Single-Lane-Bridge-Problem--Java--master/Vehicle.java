import java.util.concurrent.*;

public class Vehicle implements Runnable
{
    private String name;
    private Bridge bridge;
    public Vehicle(Bridge bridge)
    {
        this.bridge = bridge;  
    }
    
    public void run()
    {
        bridge.crossBridge(this);
    }
    //Get para el nombre del vehiculo
    public String getName()
    {
        return name;
    }
    //Set para el nombre del vehiculo.
    public void setName(String name)
    {
            this.name = name;
    }
}
