package com.nalumeya.EmplyoeeCrud.Service;

import com.nalumeya.EmplyoeeCrud.Model.EmployeeEntity;
import com.nalumeya.EmplyoeeCrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeEntity employee)
    {
        employeeRepository.save(employee);
        return "Record created with employee id: "+employee.getId();
    }

    public List<EmployeeEntity> getEmployees()
    {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> getEmpById(int id)
    {
        return employeeRepository.findById(id);
    }


    public String updateEmployee(EmployeeEntity updatedEmployee,int id)
    {
        Optional<EmployeeEntity> existingStudent=employeeRepository.findById(id);
        if (existingStudent.isPresent())
        {
            EmployeeEntity employee=existingStudent.get();
            employee.setEmpName(updatedEmployee.getEmpName());
            employee.setEmpSalary(updatedEmployee.getEmpSalary());
           employeeRepository.save(employee);
            return "Updated Employee with id: "+id+"is "+employee;
        }
        else
        {
            return "Required Employee data is not available";
        }
    }

    public String deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
        return "Employee with id:"+id+" is deleted";
    }
}
