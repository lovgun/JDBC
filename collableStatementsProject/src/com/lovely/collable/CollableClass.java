package com.lovely.collable;

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


public class CollableClass {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties pr = new Properties();
			FileReader reader;
			reader = new FileReader("resources\\db.properties");
			pr.load(reader);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arjb3", pr);
			
			CallableStatement cs = con.prepareCall("{call arjb3.fetch(?,?,?,?)}");// we can set the placeholder while calling the procedure																			 
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			ResultSet set=cs.executeQuery();
		
			while(set.next()){
			
				System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3)+" "+set.getString(4));
			}
		
			

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
