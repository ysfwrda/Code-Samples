
/**
 * Write a description of class Main here.
 *
 * @author Youssef Abouwarda
 * @version June 2020
 */
import java.util.*;
import Implementation.*;
import Common.*;
import client.*;
public class Main
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void Main()
    {
        Implementation.WindFarm windFarm1 = new Implementation.WindFarm("Walney", "United Kingdom", 659, 87, 2012);
        Implementation.WindFarm windFarm2 = new Implementation.WindFarm("London Array", "United Kingdom", 630, 175, 2013);
        Implementation.WindFarm windFarm3 = new Implementation.WindFarm("Gemini Wind Farm", "Netherlands", 600, 150, 2017);
        Implementation.PowerPlant powerPla1 = new Implementation.PowerPlant("Akkuyu", "Turkey", 1014, 2015, 2023);
        Implementation.PowerPlant powerPla2 = new Implementation.PowerPlant("Barakah", "UAE", 5380, 2012, 2020);
        Implementation.PowerPlant powerPla3 = new Implementation.PowerPlant("Karachi", "Pakistan", 2118, 2013, 2021);
        Implementation.SolarPark solarPar1 = new Implementation.SolarPark("Bhadla Solar Park", "India", 2245, 53, 2019);
        Implementation.SolarPark solarPar2 = new Implementation.SolarPark("Pavagada Solar Park", "India", 2050, 53, 2019);
        Implementation.SolarPark solarPar3 = new Implementation.SolarPark("Tengger Desert Solar Park", "China", 1547, 43, 2016);
        client.WindFarmTable windFarm4 = new client.WindFarmTable("MixedTable");
        //adding the station instances
        windFarm4.addPowerStation(windFarm1);
        windFarm4.addPowerStation(windFarm2);
        windFarm4.addPowerStation(windFarm3);
        windFarm4.addPowerStation(powerPla1);
        windFarm4.addPowerStation(powerPla2);
        windFarm4.addPowerStation(powerPla3);
        windFarm4.addPowerStation(solarPar1);
        windFarm4.addPowerStation(solarPar2);
        windFarm4.addPowerStation(solarPar3);
        //printing
        windFarm4.printTable();

    }

}
