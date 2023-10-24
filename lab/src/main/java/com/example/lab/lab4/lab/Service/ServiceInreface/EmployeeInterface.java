package com.example.lab.lab4.lab.Service.ServiceInreface;

import com.example.lab.lab4.lab.Entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeInterface{


    public Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    String getById(Integer employeeId);

    List<Employee> addAllEmployee(List<Employee> employee);

    String updateEmployeeStatus(Integer employee_id, Employee employeeStatus);

    String updateEmployeesDept(int employeeId, Map<String, Object> department);

    Employee getEmployeeById(int employeeId);

    List<Employee> getEmployeeByStatus(String status);

    List<Employee> getEmployeeByDepartment(String department);

}
