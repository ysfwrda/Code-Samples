package de.haw.databases;

import java.sql.SQLException;
import java.util.List;

import de.haw.databases.readerWriter.ConsoleReaderWriter;
import de.haw.databases.readerWriter.GuiReaderWriter;
import de.haw.databases.readerWriter.IReaderWriter;

public class Starter {

  // TODO: provide the correct JDBC-URL for the HAW database OR your local
  // database!
  static final String url = "jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14";

  static final String user = MyDBUserPassword.user;
  static final String password = MyDBUserPassword.password;

  public static void main(String[] args) throws Exception {
    PersonalProjectConnector connector = new PersonalProjectConnector(url, user, password);

    // TODO choose user interface
    IReaderWriter readerWriter = new ConsoleReaderWriter();
    // IReaderWriter readerWriter = new GuiReaderWriter();

    Starter starter = new Starter(connector, readerWriter);
    starter.start();

    readerWriter.close();
    connector.close();
  }

  /**
   * Click into the Console-window and start typing or answer the dialog
   * pop-ups.
   */
  private void start() throws SQLException {
    boolean running = true;
    while (running) {
      String input = requestInputFromUser();
      Command command = parseCommand(input);

      if (command.isExitCommand()) {
        running = false;
        readerWriter.write("See you next time!");
        
        
      }else if(command.name.equals("sessions")) {
    	  studySessionFunctionality();
      }else if(command.name.equals("csessions")) {
    	  courseSessionFunctionality(command.getOption1());
    }else{
        readerWriter.write("No matching command found for:\n" + input);
      }
      
    }
  }

  /**
   * TODO exchange by any functionality that you want
   * 
   */ 
 /* private void protoTypeFunctionality() throws SQLException {
	   //Prototype showing the course names in the database
	   List<String> result = connector.getPrototype(); //TODO Here the problem,list is empty
	   for(String st : result) 
		   readerWriter.write(st); 
   }
*/
   private void studySessionFunctionality() throws SQLException {
	   //First Use Case
	   List<Object> result = connector.getStudySessions(); //TODO Here the problem,list is empty
	   for(Object obj : result) 
		   readerWriter.write(obj);
	  		readerWriter.write("--------------------------------------");
   }
  

   private void courseSessionFunctionality(String courseNo) throws SQLException {
	   //Second Use Case
	   if (isParseableToInt(courseNo)) {
		      List<Object> result = connector.getCourseSessions(Integer.valueOf(courseNo));
		      for(Object obj : result) 
				   readerWriter.write(obj);
		      readerWriter.write("--------------------------------------");
		    } else {
		      readerWriter.write("course session command requires Course_Number");
		    }
		  }

 /*  private void studentFunctionality(String courseNumber) throws SQLException {
    if (isParseableToInt(courseNumber)) {
      //List<Object> result = connector.getStudySessions(Integer.valueOf(courseNumber));
    	List<Object> result = connector.getStudySessions();
      readerWriter.write(result);
    } else {
      readerWriter.write("student command requires <university_id>");
    }
  }*/ 

  // ================================================================================
  // Utility functionality and class init; you can look at it, change it, but
  // you don't have to
  // ================================================================================

  private final PersonalProjectConnector connector;
  private final IReaderWriter readerWriter;

  public Starter(PersonalProjectConnector connector, IReaderWriter readerWriter) {
    this.connector = connector;
    this.readerWriter = readerWriter;
  }

  /**
   * Ask user for input and return this input
   */
  private String requestInputFromUser() {
    String startDialog = "Hello friend!\n Usage: exit\n Usage: prototype \n Usage:sessions \n Usage: csessions <course number>    Example: csession 234";
    String input = readerWriter.read(startDialog);
    return input;
  }

  /**
   * Parses given string to a command object.
   */
  private Command parseCommand(String input) {
    if (input == null || input.startsWith("exit")) {
      return new Command("exit");
    }
    String[] split = input.split(" ");
    if (split.length > 1) {
      return new Command(split[0], split[1]);
    } else {
      return new Command(split[0]);
    }
  }

  /**
   * Determines if given string is parseable to integer
   */
  public static boolean isParseableToInt(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Integer.parseInt(strNum);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  public static class Command {
    private String name;
    private String option1;

    public Command(String name) {
      this(name, null);
    }

    public Command(String name, String option1) {
      this.name = name;
      this.option1 = option1;
    }

    public String getCommand() {
      return name;
    }

    public String getOption1() {
      return option1;
    }

    public boolean isExitCommand() {
      return "exit".equals(name);
    }
  }
}
