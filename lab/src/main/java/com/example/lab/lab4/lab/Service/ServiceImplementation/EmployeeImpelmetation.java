package com.example.lab.lab4.lab.Service.ServiceImplementation;

import com.example.lab.lab4.lab.Entities.Employee;
import com.example.lab.lab4.lab.Repositories.EmployeeRepository;
import com.example.lab.lab4.lab.Service.ServiceInreface.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeImpelmetation implements EmployeeInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> addAllEmployee(List<Employee> employee) {

        return employeeRepository.saveAll(employee);
    }

    @Override
    public String updateEmployeeStatus(Integer employee_id, Employee employeeStatus) {

        Optional<Employee> updateStatus = employeeRepository.findById(employee_id);
        if(updateStatus.isPresent()){
            employeeStatus.setEmployeeStatus(employeeStatus.getEmployeeStatus());
            employeeRepository.save(employeeStatus);
            return "Doctor Status Updated";
        }
        else {
            return "Doctor with employee ID" + employee_id + " is not found";
        }
    }

    @Override
    public String updateEmployeesDept(int employeeId, Map<String, Object> department) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            if (department != null) {
                updateDepartmentAttributes(employee, department);
                // You need to save the changes to the database
                employeeRepository.save(employee);
                return "Department attributes updated successfully";
            } else {
                return "Department data is null or empty.";
            }
        } else {
            return "Employee not found";
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getEmployeeByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }


    private void updateDepartmentAttributes(Employee employee, Map<String, Object> department) {
        for (Map.Entry<String, Object> entry : department.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals("newDeptName")) {
                employee.setDepartment(value.toString());
            } else {
                throw new IllegalArgumentException("Invalid attribute: " + key);
            }
        }
    }



    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public String getById(Integer employeeId) {
        if(employeeRepository.existsById(employeeId)){
            employeeRepository.getById(employeeId);
            return "Course here";
        }
        else{
            return  "Not found!";
        }

    }






}
