package com.database;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import com.employee.Emp;
import com.services.*;

public class EmpDb {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	
	Connection conn ;
	Statement stmt ;
	PreparedStatement pstmt;
	ResultSet rs ;
	
	public EmpDb() throws SQLException, ClassNotFoundException {
		super();

		
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		conn.setAutoCommit(true); // enable transaction

		System.out.println("Connection estabilished: " + conn);
		
	}
	
	public void addToDB(Emp e) throws SQLException
	{
		  
				String insertQueryForPrepareStmt = "INSERT INTO em (id,name,designation,company) VALUES (?, ?, ?, ?)";
				pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
				pstmt.setInt(1, e.getId());
				pstmt.setString(2, e.getName());
				pstmt.setString(3, e.getDesignation());
				pstmt.setString(4,e.getCompany());
				
				int insertCount1 = pstmt.executeUpdate();
				pstmt.close();
				System.out.println(insertCount1 + " Employee(s) inserted");

			    
			    
		
	}
	
	
	public void viewfromdb() throws SQLException
	{
//		System.out.println("hello" + rs);
		String selectQuery = "SELECT * FROM em";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(selectQuery);
//		System.out.println("hello" + rs);
		System.out.format("\t%s \t%s \t%s \t%s \n", "Id", "Name","Designation", "Company");
		while (rs.next()) {
			
			int id = rs.getInt("id");
			
			String name = rs.getString("name");
			String designation = rs.getString("designation");
			String company = rs.getString("company");

			
			System.out.format("\t%d \t%s \t%s \t%s \n", id,  name, designation,  company);
		}

				

		
	}
	
	public void viewById(int id) throws SQLException
	{
		String insertQueryForPrepareStmt = "Select * from em where id=?";
		pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
		pstmt.setInt(1, id);
		
		rs = pstmt.executeQuery();
		while(rs.next())
		{
		System.out.println("HELOOOO");
		int x=rs.getInt("id");
		String name=rs.getString("name");
		String desig=rs.getString("designation");
		String com=rs.getString("company");
		
		
		System.out.format("\t%d \t%s \t%s \t%s \n", x,  name, desig,  com);
		}
		pstmt.close();
		
		
	}
	
	public void deleteById(int id ) throws SQLException
	{
		
		String deleteQuery = "DELETE FROM em WHERE id = ?";
		pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, id);
		int deleteCount = pstmt.executeUpdate();
		pstmt.close();
		System.out.println(deleteCount + " Employee(s) deleted");
	}
}	
	
	
	


	

