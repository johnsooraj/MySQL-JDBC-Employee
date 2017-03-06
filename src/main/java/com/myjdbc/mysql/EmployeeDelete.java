package com.myjdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDelete {

	public EmployeeDelete(Connection connection, Scanner scanner, Employee employee) {
		try {
			System.out.println("Enter the Name Of Employee - ");
			scanner.nextLine();
			String name = scanner.nextLine();

			String query = "DELETE FROM employee WHERE name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			int result = preparedStatement.executeUpdate();
			System.err.println(result == 1 ? "All data Deleted \n" : "Error in Deletion \n");

		} catch (

		SQLException e) {
			System.err.println(e);
		}
	}
}
