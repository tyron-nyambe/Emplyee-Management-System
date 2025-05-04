package nsolutions.ems.controller;


import lombok.AllArgsConstructor;
import nsolutions.ems.dto.EmployeeDto;
import nsolutions.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
