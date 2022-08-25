package code.tfn.employeemanager.services;

import code.tfn.employeemanager.exceptions.EmployeeNotFoundException;
import code.tfn.employeemanager.models.Employee;
import code.tfn.employeemanager.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee (Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }

    public List<Employee> findAllEmployees() {
    return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
