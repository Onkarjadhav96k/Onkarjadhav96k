package com.qsp.demo.models;

public class Employee {
	private int id;
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	private String name;
	private double sal;
	@Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + sal + "]";
    }
	public static void main(String[] args) {
		
		

	}

}
