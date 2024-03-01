package com.lovely.assigment;

import java.util.Scanner;

public class registration {

	public static void main(String[] args) {
		    DbOperation db=new DbOperation();
			Scanner sc=new Scanner(System.in);
		
		
			System.out.println("Do you want to register yourself? please enter yes/no");
			String ans =sc.next();
			while(ans.equalsIgnoreCase("yes")){
				System.out.println("Enter your full name");
				sc.nextLine();
				int id=1;
				String password=null;
				String fullname=sc.nextLine();
				System.out.println("enter your email");
				String email=sc.next();
				if(email.contains("@")){
					
				}
				else{
					System.out.println(" pls include \"@\" in email" );
					email=sc.next();
				}
				if(email.contains("@")){
					
				}
				else{
					break;
				}
				System.out.println("Enter password that you want to create");
			    sc.nextLine();
			    password=sc.nextLine();
			    if(password.length()<=5){
			    	System.out.println("plz enter minimum 6 digit password");
			    	password=sc.nextLine();
			    	
			    }
				
				if(password.length()<=5){
					break;
				}
				System.out.println("enter your address");
				String address=sc.nextLine();
				db.insert(id,fullname,email,password,address);
				System.out.println("do you want to singup??pless yes/no");
				ans=sc.next();
			}
			
			System.out.println("Thankyou");
			System.out.println("do you wanne login ?please enter yes/no");
			String ansl=sc.next();
			while(ansl.equalsIgnoreCase("yes")){
				System.out.println("enter your email");
				String emaill=sc.next();
				System.out.println("Enter password ");
			    sc.nextLine();
			    String passwordl=sc.nextLine();
				db.checklogin(emaill,passwordl);
				System.out.println("do you wanne login again");
				ansl=sc.next();
			}
			
		
		
		}
			
		
			
		}

	

