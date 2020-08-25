package Implementation;
import Common.*;
/**
 * Write a description of class PowerPlant here.
 * @author (Muhammad Asad Soomauroo)
 */
public class PowerPlant extends Station
{
    //instance variables
    //private String name;
    //private String country;
    //private double capacity;
    private int constructionStart;
    private int connectionYear;

    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant( String name, String country, double capacity, int constructionStart, int  connectionYear)
    {
        //initialise instance variables
        super(name,country,capacity);
        this.constructionStart = constructionStart;
        this.connectionYear = connectionYear;
    }
    
    
    public double  getCapacity()
    
    {
        //using getter to get capacity
        return capacity;
    }
    
    
    public void print()
    {
        //print the name and values of power plant
        String print = String.format("|%-20s |%-20s |%-9f|-%9s |-%20s |%-20d |%-20d ",  name,country,capacity,"","",constructionStart,connectionYear);
        System.out.println(print);
    }
    
    
}
