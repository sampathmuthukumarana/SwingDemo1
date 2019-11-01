package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * This class is used to connect to the mysql database called dbhospital.
 */
public class MySqlConnection {
	/**
	 * This method is used to connect to the mysql database.
	 * 
	 * @return Connection This returns a Connection object called conn.
	 */
	public Connection connectDb() {

		Connection conn = null;

		try {

			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/dbhospital";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "");

		}
//	    catch (Exception e)
//	    {
//	      System.err.println("Got an exception! ");
//	      System.err.println(e.getMessage());
//	      e.printStackTrace();
//	    }

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (SQLException sql) {
			JOptionPane.showMessageDialog(null,
					"There is a problem with your database connection.Please contact your system administrator!",
					"Connection error!", JOptionPane.WARNING_MESSAGE);
			// sql.printStackTrace();

		}
		return conn;

	}
}
