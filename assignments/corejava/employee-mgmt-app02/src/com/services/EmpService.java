package com.services;
import java.util.*;

import java.util.concurrent.Callable;

import com.database.EmpDb;
import com.employee.*;

import java.io.*;
import java.sql.SQLException;


public class EmpService implements ServiceInterface {


	Scanner sc = new Scanner(System.in);
	
	EmpDb db= new EmpDb();

	public EmpService() throws SQLException ,ClassNotFoundException{
		super();
	
	}

	@Override
	public void addUser() throws SQLException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter ID, NAME , DESIGNATION,COMPANY");
		Emp n=new Emp(sc.nextInt(),sc.next(),sc.next(),sc.next());
		
		db.addToDB(n);
	
		

	}

	@Override
	public void removeUser() throws SQLException {
		System.out.println("Enter ID to delete");
   db.deleteById(sc.nextInt());

	}

	@Override
	public void viewAll() throws SQLException {

		
		db.viewfromdb();
		
		
	}

	@Override
	public void view() throws SQLException {
		
		System.out.println("Enter ID to search");
		int i=sc.nextInt();
		db.viewById(i);

		

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void importEmp() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportEmp() throws IOException {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
