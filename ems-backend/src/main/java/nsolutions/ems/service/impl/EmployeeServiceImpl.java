package nsolutions.ems.service.impl;

import lombok.AllArgsConstructor;
import nsolutions.ems.dto.EmployeeDto;
import nsolutions.ems.entity.Employee;
import nsolutions.ems.mapper.EmployeeMapper;
import nsolutions.ems.repository.EmployeeRepository;
import nsolutions.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee with the given ID does not exist : "+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
