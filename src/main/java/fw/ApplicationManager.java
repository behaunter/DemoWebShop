package fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApplicationManager {


    WebDriver driver;

    LoginHelper loginHelper;
    BaseHelper baseHelper;

    public void stop() {
        driver.quit();
    }


    public LoginHelper getLoginHelper() {
        return loginHelper;
    }
    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public void init() {
        String URL = "https://demowebshop.tricentis.com/register";

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginHelper = new LoginHelper(driver);
        baseHelper = new BaseHelper(driver);
    }

}