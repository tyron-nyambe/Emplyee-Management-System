package nsolutions.ems.controller;


import lombok.AllArgsConstructor;
import nsolutions.ems.dto.EmployeeDto;
import nsolutions.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This controller layer depends on the service layer

@AllArgsConstructor
@RestController //Means class can now handle HTTP requests
@RequestMapping("/api/employees") //Defines base URL for all api's we are able to build within the controller
public class EmployeeController {

    //Injecting the dependencies
    private EmployeeService employeeService;

    //Add employee REST API
    //Response entity is a generic type in which we have to pass the entity
    //@RequestBody notation will extract the JSON from the HTTP request and convert it to a DTO java object
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto)
    {

        EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    //Get Employee by ID
    @GetMapping("{id}")
    //@PathVariable is to bind the url template variable to the method argument
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long employeeId)
    {
        EmployeeDto foundEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(foundEmployee);

    }

    //Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
       List<EmployeeDto> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    //Update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeId,
                                                       @RequestBody EmployeeDto updatedEmployee)
    {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);

        return ResponseEntity.ok(employeeDto);

    }

    //Delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
