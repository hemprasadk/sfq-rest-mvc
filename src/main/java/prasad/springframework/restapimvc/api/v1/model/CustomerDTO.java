package prasad.springframework.restapimvc.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long Id;
    private String firstName;
    private String lastName;
    private String customerURL;
}
