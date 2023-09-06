package com.nalumeya.EmplyoeeCrud.Contoller;

import com.nalumeya.EmplyoeeCrud.Model.EmployeeEntity;
import com.nalumeya.EmplyoeeCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("employee")
    public String createEmployee(@RequestBody EmployeeEntity employee)
    {
        employeeService.createEmployee(employee);
        return ""+employee.getId();
    }

    @GetMapping("employee")
    public List<EmployeeEntity> getStudents()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("employee/{id}")
    public Optional<EmployeeEntity> getStudentByID(@PathVariable int id)
    {
        return employeeService.getEmpById(id);
    }

    @PutMapping("employee/{id}")
    public String updateEmployee(@RequestBody EmployeeEntity updatedEmployee,@PathVariable int id)
    {
        return employeeService.updateEmployee(updatedEmployee,id);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }

}
