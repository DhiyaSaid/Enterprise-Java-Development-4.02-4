package com.example.lab.lab4.lab.Controller;

import com.example.lab.lab4.lab.Entities.Employee;
import com.example.lab.lab4.lab.Entities.EmployeeStatus;
import com.example.lab.lab4.lab.Service.ServiceImplementation.EmployeeImpelmetation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeImpelmetation employeeimplementation;


    @GetMapping("/welcome")
    public String greetingUser(){
        return "Welcome User test";
    }



    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployee(){
        return employeeimplementation.getAllEmployee();
    }


    @GetMapping("/employees/{employee_id}")
    public Employee getEmployeeById(@PathVariable Integer employee_id) {
        return employeeimplementation.getEmployeeById(employee_id);
    }


    @GetMapping("/employees/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeimplementation.getEmployeeByStatus(status);
    }

    @GetMapping("/employees/status/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeimplementation.getEmployeeByDepartment(department);

    }

    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody @Valid Employee employee){
        return employeeimplementation.addEmployee(employee);
    }

    @PostMapping("/employees/addAll")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employee){
        return employeeimplementation.addAllEmployee(employee);
    }


    @PutMapping("/employees/update/{employee_id}")
    @ResponseStatus(HttpStatus.OK)
    public String getById(@PathVariable Integer employee_id, @RequestBody Employee employeeStatus){
         return employeeimplementation.updateEmployeeStatus(employee_id, employeeStatus);
    }

    @PatchMapping("/employees/update/{employee_id}")
    public String updateEmployeeDept(
            @PathVariable int employee_id,
            @RequestBody Map<String, Object> department){
        return employeeimplementation.updateEmployeesDept(employee_id, department);
    }










}
