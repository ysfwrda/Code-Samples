import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Chunter Packman" application. 
 * "Chunter Packman" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Youssef Abouwarda and Muhammad Asad Soomauroo
 * @version  2020.04.30
 */

public class Room 
{
    private String description;
    private int cheeseCount;
    private ArrayList <Item> cheeseArray;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ImageIcon image;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        cheeseArray = new ArrayList();
        cheeseCount = cheeseArray.size();
        exits = new HashMap<>();
        image = new ImageIcon();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public int getCheeseCount()
    {
        return cheeseCount;
    }

    public void setCheeseCount(int value){
        cheeseCount = value;
    }

    public void placeItem( int pieceNumber)
    {
        for(int i = pieceNumber ; i>0 ; i--)
        {
            Item cheese = new Item();
            cheeseArray.add(cheese);
            cheeseCount++;
        }
    }

    public Item takeItem()
    {
        Item last = cheeseArray.get(cheeseCount-1);
        return last;
    }

      public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {

        Image currentImage = image.getImage();
        Image modifiedImage = currentImage.getScaledInstance(600,400, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(modifiedImage);
    }
}
