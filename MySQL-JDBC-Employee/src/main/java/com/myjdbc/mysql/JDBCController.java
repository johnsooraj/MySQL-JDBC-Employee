package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCController {

	Connection connection;

	public JDBCController() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "root");
			
			if(connection != null){
				System.out.println("DATABASE CONNECTED");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDBCController();
	}

}
