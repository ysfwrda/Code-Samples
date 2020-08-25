package de.haw.databases;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

	// TODO: provide the correct class name of the driver!
	static final String driverName = "oracle.jdbc.OracleDriver";
	// TODO: provide the correct JDBC-URL for the HAW database OR your local database!
	static final String url = "jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14";
	static final String user     = MyDBUserPassword.user;
	static final String password = MyDBUserPassword.password;

	/**
	 * BOTH TEAM MEMBERS solve this
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
		DbHandler db = new DbHandler();
		
		try {
			db.connectDB(driverName, url, user, password);
			
			//db.printOrderNumbers("Ringo");
			//db.printOrderNumbers("John");
			//db.printOrderNumbers("O'Hara");
			
			int orderNumber = 5;
			db.printInvoiceForOrder(orderNumber);
			
			db.insertNewCustomer(5, "Whoever");
			
		//	db.changeArticlePrice("Apple", 1.23);
			
		} catch (SQLException e) {
			
			// TODO: print stack trace!
			e.printStackTrace();
			// TODO: Print nice error message using System.err.println() and db.getSql()!
			System.err.println(db.getSql());
		} finally {
			// TODO: close connection
			db.close();
		}
	}

}

