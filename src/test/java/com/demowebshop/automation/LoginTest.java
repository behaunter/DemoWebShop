package com.demowebshop.automation;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DataProviders;

import static org.testng.Assert.assertEquals;

public class LoginTest extends Base {

    @Test
    public void emptyFieldsOnLogin() {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("", "");
        String Unsuccessfulerror1 = app.getBaseHelper().getTextFromElement("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
        String Unsuccessfulerror2 = app.getBaseHelper().getTextFromElement("//li[contains(text(),'No customer account found')]");
        Assert.assertEquals(Unsuccessfulerror1, "Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(Unsuccessfulerror2, "No customer account found");
    }

    @Test
    public void emailNotValid() {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login(app.getBaseHelper().WrongEmail, "");
        String emailNotValidError = app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/span[1]");
        Assert.assertEquals(emailNotValidError, "Please enter a valid email address.");
    }

    @Test
    public void incorrectCridentials() {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("j@mail.ua", " ");
        String incorrectCridentialsError = app.getBaseHelper().getTextFromElement("//li[contains(text(),'The credentials provided are incorrect')]");
        Assert.assertEquals(incorrectCridentialsError, "The credentials provided are incorrect");
    }

    @Test
    public void successfullLogin() {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login("j@mail.ua", "123456");
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo, "Log out");
    }

//    @Test
//    public void loginWithRememberMe() {
//        ChromeOptions options = new ChromeOptions();
//        app.getLoginHelper().clickOnLoginButton();
//        app.getLoginHelper().clickOnRememberMe();
//        app.getLoginHelper().login("j@mail.ua", "123456");
//        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
//        app.getBaseHelper().getDriver().close();
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://demowebshop.tricentis.com/");
//        assertEquals(CustomerInfo, "Log out");
//    }

    @Test(dataProvider = "negativeUsers", dataProviderClass = DataProviders.class)
    public void incorrectCridentialsWithDataProvider(String email, String password) {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login(email, password);
        String incorrectCridentialsError = app.getBaseHelper().getTextFromElement("//li[contains(text(),'The credentials provided are incorrect')]");
        Assert.assertEquals(incorrectCridentialsError, "The credentials provided are incorrect");
    }

    @Test(dataProvider = "invalidEmailFromCSV", dataProviderClass = DataProviders.class)
    public void emailNotValidWithDataProviderCSV(String email, String password) {
        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login(email, password);
        String emailNotValidError = app.getBaseHelper().getTextFromElement("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[2]/span[1]");
        Assert.assertEquals(emailNotValidError, "Please enter a valid email address.");
    }

    @Test
    @Parameters({"Login","Password"})
    public void successfullLoginWithXML(String userName,String userPassword) {

        app.getLoginHelper().clickOnLoginButton();
        app.getLoginHelper().login(userName, userPassword);
        String CustomerInfo = app.getBaseHelper().getTextFromElement("//a[contains(text(),'Log out')]");
        assertEquals(CustomerInfo, "Log out");
    }


        @Test(expectedExceptions = NoSuchElementException.class)
        public void UserNotLoggedIn() {
            app.getBaseHelper().clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(2) > a.ico-logout");
        }

        @Test(expectedExceptions = NoSuchElementException.class)
        public void UserLoggedIn(){
            app.getLoginHelper().clickOnLoginButton();
            app.getLoginHelper().login("j@mail.ua", "123456");
            app.getBaseHelper().clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(2) > a.ico-login");
        }

    }


