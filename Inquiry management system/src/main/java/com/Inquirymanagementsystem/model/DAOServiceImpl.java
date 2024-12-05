package com.Inquirymanagementsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl  implements DAOService{

	private Statement stmnt= null;
	@Override
	public void connectDB() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:23307/imsdb","root","system");
			   stmnt= con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
		ResultSet res= stmnt.executeQuery("Select * from login where email='"+email+"' and password='"+password+"'");
		return res.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addInquiry(String name, String email, String mobile, String course) {
		try {
			
		//	stmnt.executeUpdate("INSERT INTO student (name, email, mobile, course) VALUES ('" + name + "', '" + email + "', '" + mobile + "', '" + course + "')");

			stmnt.executeUpdate("INSERT INTO student VALUES ('" + name + "', '" + email + "', '" + mobile + "', '" + course + "')");

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
	}

	@Override
	public void deleteInquiry(String email) {
		try {
			
	        	stmnt.executeUpdate("Delete from student where email='"+email+"'");

				}
				catch(Exception e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public void updateInquiry(String email, String mobile) {
		
		try {
			
        	stmnt.executeUpdate("update student set mobile='"+mobile+"'where email='"+email+"'");

			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet getAllInquiries() {
		
		try {
			ResultSet res= stmnt.executeQuery("Select * from student");
			return res;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	


