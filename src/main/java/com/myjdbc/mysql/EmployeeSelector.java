package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeSelector {

	public EmployeeSelector(Connection connection, Scanner scanner, Employee employee) throws SQLException {

		System.out.println("Enter the Name Of Employee - ");
		scanner.nextLine();
		String name = scanner.nextLine();

		String query = "SELECT * FROM employee WHERE name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.first()) {
			while (resultSet.next()) {
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPlace(resultSet.getString("place"));
				employee.setAge(resultSet.getByte("age"));
				System.out.println("\n" + employee);
			}
		} else {
			System.err.println("Employee Not Found");
		}
	}
}
