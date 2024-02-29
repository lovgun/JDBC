package com.lovely.propertiesjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo {

	public static void main(String[] args) {

        //step1:load and register the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.load and register is completed");
			//Established the connection
             Properties pr=new Properties();
             FileReader reader;
			
				reader = new FileReader("resource\\db.properties");
			
             pr.load(reader);
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/arjb3",pr);
		     System.out.println("2.connection established");
		     //create platform/statement
		     Statement st=con.createStatement();
		     System.out.println("3.platform has created");
		    //st.execute("Insert into student1 value('102','krity','java')");
		     //ResultSet rs=st.executeQuery("select * from student1");
		    int i= st.executeUpdate("update student1 set name='lovely Pandey'");
//		    while( rs.next()){
//		    	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
//		    }
		  
		    System.out.println("4.query has excuted");
		    System.out.println("no of raw effects"+" "+ i);
		    st.close();
		    System.out.println("platform has closed");
		    con.close();
		    System.out.println("connection has closed");
		} catch (ClassNotFoundException e){
		
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (	SQLException e){
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     catch (	FileNotFoundException e){
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
