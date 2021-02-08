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

    @GetMapping("/employees/{id}")
    fun findById(@PathVariable id: Long): Employee? {
        return repository.findById(id).orElseThrow()
    }

    @PostMapping("/employees")
    fun registerEmployee(@RequestBody employee: Employee): Employee {
        return repository.save(employee)
    }

    @PutMapping("/employees/{id}")
    fun updateEmployee(@RequestBody employee: Employee,
                       @PathVariable id: Long): Employee? {
        return repository.findById(id)
                .map { foundEmpmoyee ->
                    foundEmpmoyee.firstName = employee.firstName
                    foundEmpmoyee.lastName = employee.lastName
                    foundEmpmoyee.role = employee.role
                    repository.save(employee)
                }.orElseGet {
                    employee.id = id
                    repository.save(employee)
                }
    }

    fun deleteEmployee() {

    }
}