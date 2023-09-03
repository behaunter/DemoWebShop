package fw;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BaseHelper {
    WebDriver driver;
    public BaseHelper(WebDriver driver){
        this.driver = driver;

    }

    public WebDriver getDriver() {
        return driver;
    }

    public String WrongEmail = RandomStringUtils.randomAlphabetic(1,8);
    public String PasswordLessThan6 = RandomStringUtils.randomAlphabetic(5);
    public String WrongConfirmationPass = RandomStringUtils.randomAlphabetic(1,8);
    public String RandomName = RandomStringUtils.randomAlphabetic(1,8);
    public String RandomLastName = RandomStringUtils.randomAlphabetic(1,8);
    public String RandomEmail = RandomStringUtils.randomAlphabetic(1,8) + "@mail.ua";
    public String RandomPassword = RandomStringUtils.randomAlphabetic(7,15);
    Random r = new Random();
    public int zipCode = r.nextInt(8 + 1000000);
    public String randomZipCode = String.valueOf(zipCode);




    public void fillField(String text, String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
        driver.findElement(By.cssSelector(cssSelector)).clear();
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public boolean isElementDisplayed(String cssLocator) {
        return getSizeElementsOnPage(cssLocator) > 0;
    }

    public void  pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementNotDisplayed(String cssLocator) {
        return getSizeElementsOnPage(cssLocator) == 0;
    }

    public boolean countElementsOnPage(String cssSelector, int expectedCount) {
        return getSizeElementsOnPage(cssSelector) == expectedCount;
    }

    public int getSizeElementsOnPage(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector)).size();
    }

    public String getTextFromElement(String xpathExpression) {
        return driver.findElement(By.xpath(xpathExpression)).getText();
    }

    public void clickOnElementByXpath(String xpathExpression) {
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public void clickOnElementByLinkText(String LinkTextExpression) {
        driver.findElement(By.linkText(LinkTextExpression)).click();
    }
    public void clickOnElement(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
    public List<WebElement> getElementsFromPage(String csslocator){
        return driver.findElements(By.cssSelector(csslocator));
    }
}
