package com.andreilorin.springbootintro.main;

public class Client {

	private int id;
	private String name;
	private double credits;
	
	public Client() {
		id = 0;
		name = "testname";
		credits = 100.00;
	}
	
	public Client(int id, String name, double credits) {
		this.id = id;
		this.name = name;
		this.credits = credits;
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

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}
	
	
	
	
	
}
