package com.ne.neflex.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ne.neflex.mapper.EmployeeSQLMapper;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeSQLMapper employeeSQLMapper;
	
}
