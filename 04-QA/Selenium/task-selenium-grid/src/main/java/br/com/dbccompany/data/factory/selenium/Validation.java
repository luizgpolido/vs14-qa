package br.com.dbccompany.data.factory.selenium;

import static org.testng.Assert.assertEquals;

public class Validation {

    public void validateText(String expected, String Actual){
        assertEquals(expected,Actual);
    }


}