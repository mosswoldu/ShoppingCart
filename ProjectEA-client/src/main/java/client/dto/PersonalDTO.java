package client.dto;

import lombok.Data;

@Data
public class PersonalDTO extends CustomerDTO {
    private String firstname;
    private String lastname;
}
