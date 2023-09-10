package com.demowebshop.automation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationTest extends Base{


@Test
    public void emptyFieldsOnRegistration(){
    app.getLoginHelper().registration("","","","","");
    String firstNameIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'First name is required.')]");
    String lastNameIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'Last name is required.')]");
    String emailIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'Email is required.')]");
    String passwordIsRequired =  app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]/span[1]");
    String confirmPasswordIsRequired =  app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[2]/span[2]/span[1]");
    assertEquals(firstNameIsRequired,"First name is required.");
    assertEquals(lastNameIsRequired,"Last name is required.");
    assertEquals(emailIsRequired,"Email is required.");
    assertEquals(passwordIsRequired,"Password is required.");
    assertEquals(confirmPasswordIsRequired,"Password is required.");
}

    @Test
    public void SpacesInFieldsOnRegistration(){
        app.getLoginHelper().registration("   ","   ","   ","   ","   ");
        String firstNameIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'First name is required.')]");
        String lastNameIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'Last name is required.')]");
        String emailIsRequired =  app.getBaseHelper().getTextFromElement("//span[contains(text(),'Email is required.')]");
        String passwordIsRequired =  app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]/span[1]");
        String confirmPasswordIsRequired =  app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[3]/div[2]/div[2]/span[2]/span[1]");
        assertEquals(firstNameIsRequired,"First name is required.");
        assertEquals(lastNameIsRequired,"Last name is required.");
        assertEquals(emailIsRequired,"Email is required.");
        assertEquals(passwordIsRequired,"Password is required.");
        assertEquals(confirmPasswordIsRequired,"Password is required.");
    }

@Test
    public void wrongEmail(){
    app.getLoginHelper().registration("","",app.getBaseHelper().WrongEmail,"","");
    String wrongEmailLabel = app.getBaseHelper().getTextFromElement("//span[contains(text(),'Wrong email')]");
    assertEquals(wrongEmailLabel,"Wrong email");
}

@Test
    public void passwordLessThan6Symbols(){
    app.getLoginHelper().registration("","","",app.getBaseHelper().PasswordLessThan6,"");
    String passwordLessthan6Sym = app.getBaseHelper().getTextFromElement("//span[contains(text(),'The password should have at least 6 characters.')]");
    assertEquals(passwordLessthan6Sym,"The password should have at least 6 characters.");
}

@Test
    public void passwordDoNotMatch(){
    app.getLoginHelper().registration("","","",app.getBaseHelper().PasswordLessThan6,app.getBaseHelper().WrongConfirmationPass);
    String passDontMatch = app.getBaseHelper().getTextFromElement("//span[contains(text(),'The password and confirmation password do not matc')]");
    assertEquals(passDontMatch,"The password and confirmation password do not match.");
}

@Test
    public void maleRegistration(){
    app.getLoginHelper().clickOnMale();
    app.getLoginHelper().registration(app.getLoginHelper().RandomName,app.getBaseHelper().RandomLastName,app.getBaseHelper().RandomEmail,app.getBaseHelper().RandomPassword,app.getBaseHelper().RandomPassword);
    app.getBaseHelper().clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.registration-result-page div.page-body div.buttons > input.button-1.register-continue-button");
    String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
    assertEquals(CustomerInfo,"Log out");

}

    @Test
    public void femaleRegistration(){
        app.getLoginHelper().clickOnFemale();
        app.getLoginHelper().registration(app.getLoginHelper().RandomName,app.getBaseHelper().RandomLastName,app.getBaseHelper().RandomEmail,app.getBaseHelper().RandomPassword,app.getBaseHelper().RandomPassword);
        app.getBaseHelper().clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.registration-result-page div.page-body div.buttons > input.button-1.register-continue-button");
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo,"Log out");
    }

    @Test
    public void registrationWithoutGender(){
        app.getLoginHelper().registration(app.getLoginHelper().RandomName,app.getBaseHelper().RandomLastName,app.getBaseHelper().RandomEmail,app.getBaseHelper().RandomPassword,app.getBaseHelper().RandomPassword);
        app.getBaseHelper().clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.registration-result-page div.page-body div.buttons > input.button-1.register-continue-button");
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo,"Log out");
    }

}
