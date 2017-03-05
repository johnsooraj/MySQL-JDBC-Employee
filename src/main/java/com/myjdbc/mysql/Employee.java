package com.myjdbc.mysql;

public class Employee {

	private String name;
	private String email;
	private String place;
	private Byte age;

	public Employee() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", place=" + place + ", age=" + age + "]";
	}
}
