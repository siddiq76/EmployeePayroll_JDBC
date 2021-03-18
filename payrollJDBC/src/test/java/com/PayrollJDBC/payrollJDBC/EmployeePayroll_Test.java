package com.PayrollJDBC.payrollJDBC;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class EmployeePayroll_Test {

	EmployeePayroll_DB employeePayrollService = new EmployeePayroll_DB();
	
	//UC2 retrieving data and checking size
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount()
	{
		List<EmployeeData> employeePayrollData = employeePayrollService.readData();
		Assert.assertEquals(3, employeePayrollData.size());
	}
	
	// UC3 update and sync data in database
	@Test
	public void givenNewSalaryToEmployee_WhenUpdated_ShouldSyncWithDatabase()
	{
		List<EmployeeData> employeePayrollData = employeePayrollService.readData();
		employeePayrollService.updateEmployeeSalary("Terrisa",300000.0);
		boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terrisa");
		Assert.assertTrue(result);
	}
	
	// UC4 update and sync data in database (using prepared statement)
			@Test
			public void givenNewSalaryToEmployee_WhenUpdated_ShouldSyncWithDatabaseUsingPreparedStatement()
			{
				List<EmployeeData> employeePayrollData = employeePayrollService.readData();
				employeePayrollService.updateEmployeeSalary("Terrisa",300000.0);
				boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terrisa");
				Assert.assertTrue(result);
			}
			
			//UC4 matching employee count for given date range
			@Test 
			public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount()
			{
				List<EmployeeData> employeePayrollData = employeePayrollService.readData();
	            LocalDate startDate = LocalDate.of(2018,01,01);
	            LocalDate endDate = LocalDate.now();
	    		employeePayrollData = employeePayrollService.getEmpPayrollDataForDataRange(startDate, endDate);
	    		Assert.assertEquals(3, employeePayrollData.size());
			}
			//UC6 functions like sum,max,average by gender
			@Test
			public void givenPayrollData_WhenAverageSalaryByGender_ShouldReturnProperValue()  {
				employeePayrollService.readData();
				Map<String,Double> averageSalaryByGender = employeePayrollService.readAverageSalaryByGender();
				Assert.assertTrue(averageSalaryByGender.get("F").equals(300000.0));
				Assert.assertTrue(averageSalaryByGender.get("M").equals(150000.0));
			}
			
			@Test
			public void givenPayrollData_WhenMaxSalary_ShouldReturnProperValue()  {
				employeePayrollService.readData();
				Double max =employeePayrollService.getMaxSalary();
	                 Assert.assertEquals(300000.0, max,0.0);
			}

}