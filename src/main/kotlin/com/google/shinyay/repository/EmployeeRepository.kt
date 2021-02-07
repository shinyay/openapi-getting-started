package com.google.shinyay.repository

import com.google.shinyay.entity.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : CrudRepository<Employee, Long>