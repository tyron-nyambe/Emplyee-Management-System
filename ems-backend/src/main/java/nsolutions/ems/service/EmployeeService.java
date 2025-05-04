package nsolutions.ems.service;

import nsolutions.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee (EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

}
