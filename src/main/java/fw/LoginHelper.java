package fw;

import model.User;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class LoginHelper extends BaseHelper {
    public LoginHelper(WebDriver driver) {
        super(driver);
    }


    public void clickOnLoginButton(){
        clickOnElementByLinkText("Log in");
    }

    public void clickOnRegistrationButton(){
        clickOnElementByLinkText("Register");
    }
    public void login(String email,String password) {
        fillField(email, "#Email");
        fillField(password, "#Password");
        clickOnElement("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.login-page div.page-body div.customer-blocks div.returning-wrapper div.form-fields form:nth-child(1) div.buttons:nth-child(5) > input.button-1.login-button");
    }
    public void clickOnLogoutButton() {
        clickOnElementByLinkText("Log out");
    }

    public void clickOnMale(){
        clickOnElement("#gender-male");
    }
    public void clickOnFemale(){
        clickOnElement("#gender-female");
    }

    public void registration(String FirstName,String LastName,String Email, String Password, String Confirm_Password){
        fillField(FirstName, "#FirstName");
        fillField(LastName, "#LastName");
        fillField(Email, "#Email");
        fillField(Password, "#Password");
        fillField(Confirm_Password, "#ConfirmPassword");
        clickOnElement("#register-button");
    }

    public void clickOnRememberMe(){
        clickOnElement("#RememberMe");
    }

    public void clickOnForgotPassword(){
        clickOnElementByLinkText("Forgot password?");
    }



}

