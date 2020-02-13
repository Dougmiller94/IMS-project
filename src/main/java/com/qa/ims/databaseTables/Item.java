package com.qa.ims.databaseTables;

public class Item {

	private int id;
	private String name;
	private double value;

	public Item(int Id, String name, double value) {

	}

	public Item(String name, double value) {
		
		this.setName(name);
		this.setValue(value);

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void add(Item item) {
		
	}

}
