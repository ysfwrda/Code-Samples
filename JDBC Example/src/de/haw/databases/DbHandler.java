package de.haw.databases;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class holds the functionality of this program and has to be implemented
 * by you (A and B have different methods to fix).
 * 
 * @author Youssef Abouwarda //TODO add your name
 *
 */
public class DbHandler {
  /**
   * Database connection
   */
  private Connection conn;

  /**
   * The current SQL statement
   */
  private String sql;

  /**
   * Getter for the current SQL statement
   * 
   * @return the SQL statement
   */
  public String getSql() {
    return sql;
  }

  // ================================================================================
  // BOTH TEAM MEMBERS solve the following two methods
  // ================================================================================

  /**
   * BOTH TEAM MEMBERS solve this
   * 
   * Connect to the database.
   * 
   * @param driverName
   *          - name of JDBC driver class
   * @param url
   *          - JDBC URL
   * @param user
   *          - DB user name
   * @param password
   *          - DB password
   * @throws SQLException
   */

  public void connectDB(String driverName, String url, String user, String password) throws SQLException {
    System.out.println("Trying to connect to " + url);

    // TODO: connect to the DB!
    conn =DriverManager.getConnection(url, user, password);

    // TODO: disable autoCommit!
    conn.setAutoCommit( false ) ;
    //
    // Print success message and some meta data:
    //
    DatabaseMetaData metaData = conn.getMetaData();
    System.out.println("Connected to DB " + metaData.getURL() + " as user " + metaData.getUserName());
    System.out.println(metaData.getDatabaseProductName() + " " + metaData.getDatabaseMajorVersion() + "."
        + metaData.getDatabaseMinorVersion());
  }

  /**
   * BOTH TEAM MEMBERS solve this
   * 
   * Close the connection
 * @throws SQLException 
   */
  public void close() throws SQLException {
    /*
     * TODO: rollback the transaction (in real life, you'd want to commit -> but
     * then you cannot call insertNewCustomer() twice.)
     */
	  conn.rollback();
    // TODO: close the connection (if it has been initialized)
	  if(conn.isValid(0))
		  conn.close();
  }

  // ================================================================================
  // TEAM MEMBER A solves the following two methods
  // ================================================================================

  /**
   * TEAM MEMBER A solves this method, B can ignore it
   * 
   * Print an invoice for the given order. The invoice shall contain every
   * single order item and the total price.
   * 
   * @param orderNumber
   *          - value for o_nr
   * @throws SQLException
   */
  public void printInvoiceForOrder(int orderNumber) throws SQLException {
	  Statement myStatement = conn.createStatement();
    System.out.println("Invoice for order number " + orderNumber);

    // Optional: You could print customer information here!

    /*
     * TODO: For every order item, print the article name, the article's price
     * per unit, the quantity, and the price of the order item. SQL see
     * assignment 9-14
     */
    sql = "SELECT o_nr,name,price,quantity,price*quantity AS Total" + 
    		"FROM order_item JOIN article ON order_item.a_nr = article.a_nr" + 
    		"WHERE o_nr = 5" + 
    		"ORDER BY name;";
     

    System.out.println("-----------------------");

    /*
     * TODO: Print the total price of the order. You can calculate the sum via
     * SQL (see assignment 9-15), or in Java.
     */
    sql = "SELECT SUM(price*quantity) AS Total_PRICE\r\n" + 
    		"FROM order_item JOIN article ON order_item.a_nr = article.a_nr\r\n" + 
    		"WHERE o_nr = 5";
    ResultSet invoiceResult =myStatement.executeQuery(sql);
    
    while(invoiceResult.next()){
    int totalPrice =invoiceResult.getInt(1);
    System.out.println(totalPrice);
    }
  }

  /**
   * TEAM MEMBER A solves this method, B can ignore it
   * 
   * Insert a new customer
   * 
   * @param id
   *          - customer ID
   * @param name
   *          - customer name
   * @throws SQLException
   */
  public void insertNewCustomer(int id, String name) throws SQLException {
    System.out.println("Trying to insert new customer. id=" + id + ", name=" + name);
    
    // TODO: insert a new customer with the given values
    sql = "INSERT INTO CUSTOMER VALUES(?,?)";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1,id);
    pst.setString(2, name);
    ResultSet cursor = pst.executeQuery();
  }

  // ================================================================================
  // TEAM MEMBER B solves the following two methods
  // ================================================================================

  /**
   * TEAM MEMBER B solves this method, A can ignore it
   * 
   * Print the list of order numbers for the given customer
   * 
   * @param customer
   *          - Name of customer
   * @throws SQLException
   */
  /*
  public void printOrderNumbers(String customer) throws SQLException {
    System.out.println(customer + "'s orders:");

    // TODO: SQL see assignment 9-10
    sql = "";
  }
*/
  /**
   * TEAM MEMBER B solves this method, A can ignore it
   * 
   * Change the article's price
   * 
   * @param articleName
   *          - identifies the article
   * @param price
   *          - the new price
   * @throws SQLException
   */
  /*
  public void changeArticlePrice(String articleName, double price) throws SQLException {
    System.out.println("Trying to set the price of " + articleName + " to " + price);
    sql = "";
    int n = 0;

    // TODO: change the article's price
    sql = "";

    System.out.println("Number of rows affected: " + n);
  }*/
  
}
