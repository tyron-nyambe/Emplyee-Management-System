package nsolutions.ems.repository;

import nsolutions.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//The jpa repository inherits all the methods from all the extended interfaces
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
