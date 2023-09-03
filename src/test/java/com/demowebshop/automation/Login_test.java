package com.demowebshop.automation;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Login_test extends Base{

    @Test
    public void emptyFieldsOnLogin(){
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("", "");
        String Unsuccessfulerror1 = app.getBaseHelper().getTextFromElement("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
        String Unsuccessfulerror2 =  app.getBaseHelper().getTextFromElement("//li[contains(text(),'No customer account found')]");
        Assert.assertEquals(Unsuccessfulerror1,"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(Unsuccessfulerror2, "No customer account found");
    }
    @Test
    public void emailNotValid(){
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login(app.getBaseHelper().WrongEmail,"");
        String emailNotValidError =  app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/span[1]");
        Assert.assertEquals(emailNotValidError,"Please enter a valid email address.");
    }

    @Test
    public void incorrectCridentials(){
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("j@mail.ua", " ");
        String incorrectCridentialsError =  app.getBaseHelper().getTextFromElement("//li[contains(text(),'The credentials provided are incorrect')]");
        Assert.assertEquals(incorrectCridentialsError,"The credentials provided are incorrect");
    }

    @Test
    public void successfullLogin(){
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("j@mail.ua", "123456");
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo,"Log out");
    }

    @Test
    public void loginWithRememberMe(){
        ChromeOptions options = new ChromeOptions();
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().clickOnRememberMe();
        app.getLoginHelper().login("j@mail.ua", "123456");
        app.getBaseHelper().getDriver().close();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo,"Log out");
    }


}
