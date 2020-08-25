/**
 * *  This class is the main class of the "Chunter Pac" application. 
 *  "Chunter Pac" is a very simple, text based adventure game.  Users 
 *  can walk around to collect pieces of cheese. That's all.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Youssef Abouwarda and Muhammad Asad Soomauroo
 * @version  2020.06.07
 */
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private int totalCheese;
    private int cheeseCollected;
    private Stack <Room> currentRooms;
    private Stack <Integer> cheeseCounts;
    private boolean isWon;
    private boolean finished;
    private int seconds;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()   
    {
        createRooms();
        parser = new Parser();
        currentRooms = new Stack();
        cheeseCounts = new Stack();
        seconds = 60;
        finished = false;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, rightWardrobe, leftWardrobe, rightCompartment, leftCompartment;

        // create the rooms
        outside = new Room("outside the fridge");

        rightWardrobe = new Room("in the right wardrobe");
        rightWardrobe.placeItem(2);

        leftWardrobe = new Room("in the left wardrobe");
        leftWardrobe.placeItem(2);

        rightCompartment = new Room("in the right compartment");
        rightCompartment.placeItem(1);

        leftCompartment = new Room("in the left compartment");
        leftCompartment.placeItem(2);

        // initialise room exits
        //Outside exits

        outside.setExit("right", rightCompartment);
        outside.setExit("left", leftCompartment);

        //Right Compartment exits
        rightCompartment.setExit("down", rightWardrobe);
        rightCompartment.setExit("left", leftCompartment);

        //Left Compartment exits
        leftCompartment.setExit("down", leftWardrobe);
        leftCompartment.setExit("right", rightCompartment);

        //Right wardrobe exits
        rightWardrobe.setExit("left", leftWardrobe);
        rightWardrobe.setExit("up",rightCompartment);

        //Left wardrobe exits
        leftWardrobe.setExit("right", rightWardrobe);
        leftWardrobe.setExit("up",leftCompartment);

        outside.setImage(new ImageIcon(getClass().getResource("./Outside.jpeg")));
        rightWardrobe.setImage(new ImageIcon(getClass().getResource("Right wardrobe.jpg")));
        leftWardrobe.setImage(new ImageIcon(getClass().getResource("left Wardrobe.jpg")));
        rightCompartment.setImage(new ImageIcon(getClass().getResource("right Compartment.jpg")));
        leftCompartment.setImage(new ImageIcon(getClass().getResource("Left Compartment.jpg")));
        
        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean complete = false;
        while (! complete) {
            Command command = parser.getCommand();
            isFinished();
            complete = finished;
        }
        if (cheeseCollected<5)
        {
            isWon =false;
            System.out.println("You lost! \n Hard luck, Try Again");

        }
        else
        {
            isWon = true;
            System.out.println("You Won! Congratulations");
        }

    }

    /**
     * Print out the opening message for the player.
     */
    /*
    private void printWelcome()
    {
    System.out.println();
    System.out.println("Welcome to Chunter Pacman!");
    System.out.println("Chunter Packman is a new, incredibly interisting adventure game.");
    System.out.println("Type 'help' if you need help.");
    System.out.println();
    System.out.println(currentRoom.getLongDescription());
    }
     */
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    /* private boolean processCommand(Command command) 
    {
    boolean wantToQuit = false;

    if(command.isUnknown()) {
    System.out.println("I don't know what you mean...");
    return false;
    }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help")) {
    printHelp();
    }
    else if (commandWord.equals("go")) {
    goRoom(command);
    }
    else if (commandWord.equals("quit")) {
    wantToQuit = quit(command);
    }
    else if(commandWord.equals("back")){
    goBack();
    }   
    // else command not recognised.
    return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public String printHelp() 
    {
        return "You are lost. \n" +"around at the Fridge. \n" +"Your command words are.";

    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    public String goRoom(Command command) 
    {
        String destiny = "";
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            destiny ="Go where?";
            return destiny;
        }

        String direction = command.getSecondWord();

        currentRooms.push(currentRoom);
        cheeseCounts.push(cheeseCollected);

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            destiny ="There is no door!";
        }
        else {
            currentRoom = nextRoom;
            //Adding the cheese from the room to our collected cheese number
            cheeseCollected += currentRoom.getCheeseCount();
            destiny = currentRoom.getLongDescription();

        }
        return destiny;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    public String quit(Command command) 
    {
        if(command.hasSecondWord()) {
            return"Quit what?";
        }
        else {
            return "Thank you for playing \n Hope you enjoyed, Bye";  
        }
    }

    public String goBack()
    {
        String destiny ="";
        currentRoom =currentRooms.pop();
        cheeseCollected = cheeseCounts.pop();
        destiny =currentRoom.getLongDescription();
        return destiny;
    }

    private void isFinished()
    {
        finished = false;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.printf(" \n You have %d seconds left",seconds);
                    if (seconds > 0)
                        seconds--;

                    if (seconds == 0 )
                    {
                        finished = true;
                    }}
            };
        timer.schedule(task, 0, 1000);
        return;
    }

    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }

}

