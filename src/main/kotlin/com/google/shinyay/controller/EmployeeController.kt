package com.google.shinyay.controller

import com.google.shinyay.entity.Employee
import com.google.shinyay.repository.EmployeeRepository
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Employee Management")
class EmployeeController(val repository: EmployeeRepository) {

    @GetMapping("/employees")
    fun findAll(): MutableIterable<Employee> {
        return repository.findAll()
    }

    @GetMapping("/employees/{id}")
    fun findById(@PathVariable @Parameter(name = "Employee ID", description = "Unique Identifier for Employee", required = true) id: Long): Employee? {
        return repository.findById(id).orElseThrow()
    }

    @PostMapping("/employees")
    fun registerEmployee(@RequestBody employee: Employee): Employee {
        return repository.save(employee)
    }

    @PutMapping("/employees/{id}")
    fun updateEmployee(@RequestBody employee: Employee,
                       @PathVariable @Parameter(name = "Employee ID", description = "Unique Identifier for Employee", required = true) id: Long): Employee? {
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

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@RequestParam @Parameter(name = "Employee ID", description = "Unique Identifier for Employee", required = true) id: Long) {
        repository.deleteById(id)
    }

    @GetMapping("/hello")
    fun hello(): String {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(dateFormatter)
        return "Current Time: $currentTime"
    }
}