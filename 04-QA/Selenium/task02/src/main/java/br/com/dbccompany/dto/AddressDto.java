package br.com.dbccompany.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {

    private String FirstName;
    private String LastName;
    private String Company;
    private String Address1;
    private String Address2;
    private String City;
    private String State;
    private String PostCode;
    private String Phone;
    private String PhoneMobile;
    private String AdditionalInfo;
    private String AddressTitle;


}
