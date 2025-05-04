package nsolutions.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//This will be used as the response for the Rest API's
//This is where the JSON gets deserialized into an EmployeeDto
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
