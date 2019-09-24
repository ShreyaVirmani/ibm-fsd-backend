package com.services;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface ServiceInterface {
	void addUser() throws SQLException;
	void removeUser() throws SQLException;
	void viewAll() throws SQLException;
	void view() throws SQLException;
	void update();
	void importEmp() throws FileNotFoundException;
	void exportEmp() throws IOException;
	

}