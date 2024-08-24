package br.com.dbccompany.factory.data;

import br.com.dbccompany.dto.AddressDto;
import br.com.dbccompany.util.DataFakerGenerator;

public class AddressData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public AddressDto novoEndereco() {
        AddressDto dto = new AddressDto();

        dto.setFirstName(dataFakerGenerator.firstNameFaker());
        dto.setLastName(dataFakerGenerator.lastnameFaker());
        dto.setCompany(dataFakerGenerator.companyFaker());
        dto.setAddress1(dataFakerGenerator.addressFaker());
        dto.setAddress2(dataFakerGenerator.addressSecondFaker());
        dto.setCity(dataFakerGenerator.cityFaker());
        dto.setPostCode(dataFakerGenerator.postalCodeFaker());
        dto.setPhone(dataFakerGenerator.homePhoneFaker());
        dto.setPhoneMobile(dataFakerGenerator.mobilePhoneFaker());
        dto.setAdditionalInfo(dataFakerGenerator.textFaker());
        dto.setAddressTitle(dataFakerGenerator.titleFaker());

        return dto;
    }

    public AddressDto enderecoAliasLongo() {
        AddressDto dto = novoEndereco();
        dto.setAddressTitle(dataFakerGenerator.longTextFaker());
        return dto;
    }

    public AddressDto enderecoCompanyLongo() {
        AddressDto dto = novoEndereco();
        dto.setCompany(dataFakerGenerator.longTextFaker());
        return dto;
    }
}