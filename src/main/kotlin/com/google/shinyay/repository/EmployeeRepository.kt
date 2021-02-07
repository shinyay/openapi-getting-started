package com.google.shinyay.repository

import com.google.shinyay.entity.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<Employee, Long>