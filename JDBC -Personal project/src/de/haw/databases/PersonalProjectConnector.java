package de.haw.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides any access to your database and has to be implemented by
 * you.
 * 
 * @author Youssef Abouwarda //TODO
 *
 */
public class PersonalProjectConnector implements AutoCloseable {
	protected Connection connection;
	public PersonalProjectConnector(String url, String user, String password) throws SQLException {
		// TODO establish the connection
		connection = DriverManager.getConnection(url, user, password);
	}

	@Override
	public void close() throws SQLException {
		// TODO: close the connection
		connection.close();
	}

	/**
   * TODO rename method to name what it provides <br>
   * TODO change params and return type <br>
   * TODO implement missing parts
   * TODO delete placeholder answers
   */

	
	//First use case: Display the study sessions done by each student
	
	  public List<Object> getStudySessions( ) throws SQLException {
		  List<Object> result = new ArrayList<>(); 
	  String sql ="Select id,FNAME,LNAME,Session_number, Course_Name,(to_number(to_char(ENDTIME,'sssss')) - to_number(to_char(STARTTIME,'sssss')))/3600 AS Period " + 
	  		"FROM STUDYSESSION " + 
	  		"JOIN STUDENT ON Student.id = STUDENT_ID " + 
	  		"JOIN ADDS_TO ON Snumber = Session_number " + 
	  		"JOIN COURSE  ON Cnumber = Course_number ";
	  
	  PreparedStatement statement = connection.prepareStatement(sql);
	  ResultSet resultSet = statement.executeQuery();
	  
	  while (resultSet.next()) { 
		result.add(resultSet.getInt(1));
		result.add(resultSet.getString(2));
		result.add(resultSet.getString(3));
		result.add(resultSet.getInt(4));
		result.add(resultSet.getString(5));
		result.add(resultSet.getInt(6));
	  }
	  
	  return result; }
	 
	  public List<Object> getCourseSessions(Integer courseNo) throws SQLException {
		  List<Object> result = new ArrayList<>(); 
		  int courseNumber = courseNo ; 
	  String sql ="Select Course_Name,SESSION_Number,Student.Lname,(to_number(to_char(ENDTIME,'sssss')) - to_number(to_char(STARTTIME,'sssss')))/3600 AS Period " + 
	  		"FROM studysession " + 
	  		"JOIN ADDS_TO ON Snumber =session_number " + 
	  		"JOIN COURSE ON COURSE_Number = CNUMBER " + 
	  		"JOIN STUDENT ON id  = student_ID " + 
	  		"WHERE COURSE_NUMBER =?";
	  
	  PreparedStatement statement = connection.prepareStatement(sql);
	  statement.setInt(1, courseNumber);
	  ResultSet resultSet = statement.executeQuery();
	  
	  while (resultSet.next()) { 
		result.add(resultSet.getString(1));
		result.add(resultSet.getInt(2));
		result.add(resultSet.getString(3));
		result.add(resultSet.getInt(4));
	  }
	  
	  return result; }

}
