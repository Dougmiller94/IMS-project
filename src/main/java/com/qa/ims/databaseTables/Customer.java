package com.qa.ims.databaseTables;

public class Customer {

	private int id;
	private String name;
	private String surname;

	public Customer(int id, String name, String surname) {

		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
	}
	
	public Customer(String name, String surname) {

		
		this.setName(name);
		this.setSurname(surname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
