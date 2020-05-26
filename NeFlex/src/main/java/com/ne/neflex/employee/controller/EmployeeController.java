package com.ne.neflex.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ne.neflex.employee.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	public String empMyPage() {
		return "employee/emp_my_page";
	}
	
}
