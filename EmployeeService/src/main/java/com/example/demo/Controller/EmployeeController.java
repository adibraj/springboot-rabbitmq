package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmpPublish;

@RestController(value="/employee/")
public class EmployeeController {
	
	@Autowired
	EmpPublish service;
	
	@GetMapping("{id}")
	String returnEmployee(@PathVariable("id") int id,@RequestParam("name") String name)
	{
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setCreater("EmployeeService");
		service.sendEmpMessage(emp);
		return "Message Sent";
		
	}

}
