package br.com.dbccompany.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class AccountDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
