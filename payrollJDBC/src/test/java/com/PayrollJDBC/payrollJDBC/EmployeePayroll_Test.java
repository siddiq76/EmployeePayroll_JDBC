package com.PayrollJDBC.payrollJDBC;

import java.time.LocalDate;
import java.util.List;
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
}