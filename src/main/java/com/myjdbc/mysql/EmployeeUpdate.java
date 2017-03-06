package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeUpdate {

	public EmployeeUpdate(Connection connection, Scanner scanner, Employee employee) {
		try {
			System.out.println("Enter the Name Of Employee - ");
			scanner.nextLine();
			String name = scanner.nextLine();

			String query = "SELECT * FROM employee WHERE name=?";
			PreparedStatement preparedStatement;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPlace(resultSet.getString("place"));
				employee.setAge(resultSet.getByte("age"));
				System.out.println("\nEmployee data in Database \n" + employee + "\n");
			}

			System.out.println("Enter the name of Employee ?");
			employee.setName(scanner.nextLine());
			System.out.println("Enter the Email Address ?");
			employee.setEmail(scanner.nextLine());
			System.out.println("Enter the Place ?");
			employee.setPlace(scanner.nextLine());
			System.out.println("Enter the Age ?");
			employee.setAge(Byte.parseByte(scanner.nextLine()));

			System.out.println(employee);

			String query2 = "UPDATE employee SET name=?,email=?,place=?,age=? WHERE name=?";
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPlace());
			preparedStatement.setByte(4, employee.getAge());
			preparedStatement.setString(5, name);
			int result = preparedStatement.executeUpdate();
			System.err.println(result == 1 ? "All data Updated \n" : "Error in Insertion \n");

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
