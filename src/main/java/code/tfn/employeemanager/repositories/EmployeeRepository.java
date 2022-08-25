package code.tfn.employeemanager.repositories;

import code.tfn.employeemanager.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
