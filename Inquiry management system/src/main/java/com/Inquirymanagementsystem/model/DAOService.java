package com.Inquirymanagementsystem.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public ResultSet getAllInquiries();
	public void addInquiry(String name, String email,String mobile,String course);
	public void deleteInquiry(String email);
	public void updateInquiry(String email,String mobile);
	public void closeDB();
		
	

}
