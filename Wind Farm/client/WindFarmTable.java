
package client;
import Common.*;
import Implementation.*;
import java.util.*;
/**
 * class WindFarmTable.
 *
 * @author Youssef Abouwarda
 * @version May 2020
 */
public class WindFarmTable
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList <IWindFarm> windFarmList;   

    /**
     * Constructor for objects of class WindFarmTable
     */
    public WindFarmTable(String name){
        // initialise instance variables
        this.name = name;
        windFarmList = new ArrayList<>();
    }

    //Method to add Power Stations
    public void addPowerStation( IWindFarm powerStation){
        // Adding the power station to the arraylist
        windFarmList.add(powerStation);
    }

    //Method to calculate total power
    public double getTotalPower(){
        //  
        double totalPower = 0;
        for(IWindFarm farm : windFarmList)
            totalPower += farm.getCapacity();

        return totalPower;
    }

    public void printTable(){
        System.out.printf("%-42s |%-48s |%-35s  | %-35s \n",  "Common Variables","Spec.Variable WindFarm","Spec.Variable PowerPlant","Spec. Variable Solar Park");
        System.out.printf("%-30 |%-20s |%-9s |%-9s |%-20s |%-20s |%-20s |%-20s |   \n",  "Name","Country","Capacity","No. of Turbines","Year Commisioned", "ConstructionStart","ConnectionYear","Land Size","Connection Year");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for(IWindFarm farm : windFarmList)
            farm.print();
    }
}