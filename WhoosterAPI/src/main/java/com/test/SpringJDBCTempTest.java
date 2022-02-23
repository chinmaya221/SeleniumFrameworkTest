package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.whooster.models.Employee;

public class SpringJDBCTempTest {
	
	
	public static void main(String[] args) {
		
		DriverManagerDataSource dataSoucre = new DriverManagerDataSource();
		dataSoucre.setDriverClassName("com.mysql.jdbc.Driver");
		dataSoucre.setUrl("jdbc:mysql://localhost:3306/sys");
		dataSoucre.setUsername("root");
		dataSoucre.setPassword("root");
		
		JdbcTemplate jdbcTemplate  = new JdbcTemplate(dataSoucre);
		
		String sql = "select * from employee";
		
		RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
			
			public Employee mapRow(ResultSet result, int row)throws SQLException {
				int empId = result.getInt("empId");
				String empName = result.getString("empName");
				String empAge = result.getString("empAge");
				String empSalary = result.getString("empSalary");
				return new Employee(empId, empName, empAge, empSalary);
			}
			
			
		};
		
		List<Employee> listEmployee = jdbcTemplate.query(sql, rowMapper);
		for (Employee emp:listEmployee) {
			System.out.println(emp);
		}
		
		
	
		
		
	}
	
	

}
