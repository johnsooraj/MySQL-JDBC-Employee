package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCAdministrator {

	Connection connection;
	Scanner scanner;
	Employee employee;

	public JDBCAdministrator() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "root");

			if (connection != null) {
				System.out.println("DATABASE CONNECTED");
			} else {
				System.exit(0);
			}

			scanner = new Scanner(System.in);
			employee = new Employee();

			while (true) {
				System.out.println("Enter your Operation ?");
				System.out.println(
						"1-Add new EMPLOYEE \n2-Get EMPLOYEE \n3-Delete EMPLOYEE \n4-Update EMPLOYEE \nAny key to EXIT");
				int operation = scanner.nextInt();
				switch (operation) {
				case 1:
					new EmployeeRegistration(connection, scanner, employee);
					break;
				case 2:
					new EmployeeSelector(connection, scanner, employee);
					break;
				case 3:
					new EmployeeDelete(connection, scanner, employee);
					break;
				case 4:
					new EmployeeUpdate(connection, scanner, employee);
					break;
				default:
					System.exit(0);
					break;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDBCAdministrator();
	}

}
