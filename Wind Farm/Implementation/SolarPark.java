package Implementation;

/**
 * Class SolarPark
 *
 * @author Youssef Abouwarda
 * @version May 2020
 */
public class SolarPark extends Station
{
    // instance variables - replace the example below with your own
    int landSize;
    int connectionYear;

    /**
     * Constructor for objects of class SolarPark
     */
    public SolarPark(String name, String country, double capacity, int landSize, int connectionYear)
    {
        super(name,country,capacity);
        this.landSize = landSize;
        this.connectionYear = connectionYear;
    }

    // SolarPark implementation of print method.
    public void print()
    {
        String  print = String.format("|%-20s |%-20s |%-9f|-%9s |-%20s |%-20s |%-20s |%-8d |-%8d",  name,country,capacity,"","","","",landSize,connectionYear);
        System.out.println(print);
    }
}
