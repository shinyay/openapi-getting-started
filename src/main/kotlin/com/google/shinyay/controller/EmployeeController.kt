package com.google.shinyay.controller

import com.google.shinyay.entity.Employee
import com.google.shinyay.repository.EmployeeRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class EmployeeController(val repository: EmployeeRepository) {

    @GetMapping("/employees")
    fun findAll(): MutableIterable<Employee> {
        return repository.findAll()
    }

    @PostMapping("/employee")
    fun registerEmployee(@RequestBody employee: Employee): Employee {
        return repository.save(employee)
    }
}