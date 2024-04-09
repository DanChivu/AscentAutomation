package pageObjects;

import helper.PassSignIn;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.function.BooleanSupplier;

public class LoginPage extends Page {

    @FindBy(xpath= "//*[@id=\'email\']")
    WebElement usernameField;

    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath ="/html/body/app/ng-component/div/div[1]/div[2]/login/form/submit-control/btn/button" )
    WebElement loginButton;

   /* private By inputUsername = By.id("#email");
    private String inputPassword = "#password";
    private String btnSubmit = "button[type='submit']";
    private String btnClose = "//button[text()='Close']";
    private String acceptCookieBtn = "//button/span[text()=' Accept All ']";
    public String profileMenu = "//ul[@class=\"drop-down profile\"]";
    private String loginOutBtn = "//a[contains(text(),\"Log out\")]";*/

    public void login() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        usernameField.sendKeys(PassSignIn.getLoginName());
        loginButton.click();
        passwordField.sendKeys(PassSignIn.getPassword());
        loginButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(driver.findElement((By.id("main-nav"))).isDisplayed());
    }
}


