package nsolutions.ems.mapper;


import nsolutions.ems.dto.EmployeeDto;
import nsolutions.ems.entity.Employee;


public class EmployeeMapper {

    /*Here the entity is converted into a Dto i.e the saved entity in the DB
    converted back into a Dto to send to the client
     We return a DTO because we don't want to expose the full Employee entity (sometimes it might have internal fields,
      or you want a clean API response).
     */
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //Here the Dto is turned into an Employee entity that can be saved into the DB
    public static Employee mapToEmployee(EmployeeDto employeeDto){

        //Real JPA entity ready for the DB
        //The DB layer (JPA) only works with our entity Employee not the EmployeeDto
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
