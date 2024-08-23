package br.com.dbccompany.factory.data;

import br.com.dbccompany.dto.AccountDto;
import br.com.dbccompany.util.DataFakerGenerator;

public class SignUpData {


    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();


    public AccountDto cadastroValido() {

        AccountDto accountDto = new AccountDto();
        accountDto.setEmail(dataFakerGenerator.emailFaker());
        accountDto.setPassword(dataFakerGenerator.senhaFaker());
        accountDto.setFirstName(dataFakerGenerator.firstNameFaker());
        accountDto.setLastName(dataFakerGenerator.lastnameFaker());

        return accountDto;
    }




}
