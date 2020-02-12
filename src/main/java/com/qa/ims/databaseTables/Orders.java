package com.qa.ims.databaseTables;

public class Orders {

	private int id;
	private int customerId;
	private double value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value2) {
		this.value = value2;
	}

	public Orders(int id, int customerId, double value) {

		this.setId(id);
		this.setCustomerId(customerId);
		this.setValue(value);

	}

}
