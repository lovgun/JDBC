package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {

        //step1:load and register the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.load and register is completed");
			//Established the connection

		    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/arjb3?user=root&password=root");
		     System.out.println("2.connection established");
		     //create platform/statement
		     Statement st=con.createStatement();
		     System.out.println("3.platform has created");
		    st.execute("Insert into student1 value('101','lovely','cs')");
		    System.out.println("4.query has excuted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
