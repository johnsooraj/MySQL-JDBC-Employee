package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeRegistration {

	public EmployeeRegistration(Connection connection, Scanner scanner, Employee employee) throws SQLException {

		System.out.println("Enter the name of Employee ?");
		scanner.nextLine();
		employee.setName(scanner.nextLine());
		System.out.println("Enter the Email Address ?");
		employee.setEmail(scanner.nextLine());
		System.out.println("Enter the Place ?");
		employee.setPlace(scanner.nextLine());
		System.out.println("Enter the Age ?");
		employee.setAge(Byte.parseByte(scanner.nextLine()));

		System.out.println(employee);

		String query = "INSERT INTO employee (name, email, place, age) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setString(3, employee.getPlace());
		preparedStatement.setByte(4, employee.getAge());
		int result = preparedStatement.executeUpdate();
		System.out.println(result == 1 ? "All data saved \n" : "Error in Insertion \n");
	}

}
