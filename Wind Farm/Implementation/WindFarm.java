package Implementation;
import Common.*;
/**
 *  class WindFarm.
 *
 * @author Youssef Abouwarda
 * @version May 2020
 */
public class WindFarm extends Station 
{
    // instance variables
    //private String name;
    //private String country;
    //private double capacity;
    int numberTurbines;
    int year;

    /**
     * Constructor for objects of class WindFarm
     */

    public WindFarm(String name, String country, double capacity, int numberTurbines, int year)
    {
        // initialise instance variables
        super(name,country,capacity);

        this.numberTurbines = numberTurbines;
        this.year = year;
    }

    //Mehod for printing
    public void print()
    {
        // put your code here
        String  print = String.format("|%-20s |%-20s |%-9f |%-20d |%-20d ",name,country,capacity,numberTurbines,year);
        System.out.println(print);
    }

}
