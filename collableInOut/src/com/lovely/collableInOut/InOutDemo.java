package com.lovely.collableInOut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class InOutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties pr = new Properties();
			FileReader reader;
			reader = new FileReader("resource\\db.properties");
			pr.load(reader);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjb3", pr);
			
			CallableStatement cs = con.prepareCall("{call arjb3.update(?,?)}");// we can set the placeholder while calling the procedure																			 
			cs.setDouble(1, 10.00);
			cs.setInt(2,102);
			cs.executeUpdate();
			System.out.println("now id is"+ " "+cs.getDouble(1));
			
			
			

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	

}
