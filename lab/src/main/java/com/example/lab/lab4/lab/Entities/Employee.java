package com.example.lab.lab4.lab.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    private Integer employee_id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    public Employee() {
    }

    public Employee(Integer employee_id, String department, String name, EmployeeStatus employeeStatus) {
        this.employee_id = employee_id;
        this.department = department;
        this.name = name;
        this.employeeStatus = employeeStatus;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_id, employee.employee_id) && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && employeeStatus == employee.employeeStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, department, name, employeeStatus);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}