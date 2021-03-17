package com.PayrollJDBC.payrollJDBC;

import java.sql.Date;

public class EmployeeData {

	private String name;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setName(String name) {
		this.name = name;
	}

	private double salary;
	private Date start;

	public EmployeeData(int id, String name, double salary, Date start) {
              this.id = id;
              this.name = name;
              this.salary= salary;
              this.start=start;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", ID=" + id + ", Salary=" + salary + ", Start_date=" + start;
	}
}