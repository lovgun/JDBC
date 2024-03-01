package com.lovely.assigment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbOperation {
	Connection connection=connection();

	public void insert(int id, String fullname, String email, String password, String address) {
		// TODO Auto-generated method stub
	
		try {
			Statement st=connection.createStatement();
		    st.execute("insert into user values ("+id+",'"+fullname+"','"+email+"','"+password+"','"+address+"')");
		    Scanner sc=new Scanner(System.in);
		    System.out.println("do you wanna see your details y/n");
		    String ans=sc.next();
		    if(ans.equalsIgnoreCase("y")){
		    		ResultSet rs=st.executeQuery("select * from user");
		    		while(rs.next()){
		    			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
		    		}
		    }
		    		
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Connection connection(){
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.load and register the driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/arjb3?user=root&password=root");
			System.out.println("established the connection");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public void checklogin(String email, String password) {
		
		try {
			/*Statement st=connection.createStatement();
			 ResultSet rs=st.executeQuery("select * from user where email=email and password=password");*/
			 
			 PreparedStatement ps = connection.prepareStatement("select * from user where email=? and password=?");
			    ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
			 
			
			 
			 if(rs!=null && rs.next() ){
				 System.out.println("login successful"+" ");
				 System.out.println(rs.getInt(1)+" "+rs.getString(2));
			 }
			 else{
				 System.out.println("login failed");
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

}
