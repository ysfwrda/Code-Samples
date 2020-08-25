package Implementation;
import Common.*;

/**
 * Abstract class Station 
 *
 * @author Youssef Abouwarda
 * @version May 2020
 */
public abstract class Station implements IWindFarm 
{
    // The instance variables
    protected String name;
    protected String country;
    protected double capacity;
    
    public abstract void print();
    protected Station(String name,String country, double capacity)
    {
        this.name = name;
        this.country = country;
        this.capacity = capacity;
    }
    
    public double getCapacity(){
       return capacity; 
     }
   
    
}
