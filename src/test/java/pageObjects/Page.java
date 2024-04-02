package pageObjects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Page {

    @FindBy(xpath="//*[@id=\"mat-dialog-0\"]/tasks-list-dialog/mat-dialog-actions/btn/button")
    WebElement closeButton;

    public void clickCloseButton(){

        closeButton.click();
    }
//.addArguments("--headless")
    static ChromeOptions options = new ChromeOptions();
    static WebDriver driver = new ChromeDriver(options);

    public static WebDriver getDriver() {
        return driver;
    }
    public static ChromeOptions getOptions() {
        return options;
    }
    public  Wait<WebDriver> wait =
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);
    public static void openURL(WebDriver driver, String environmentName, String path) {
        driver.get(STR."https://\{environmentName}.k2relo.com/\{path}");
        // await browser.url(`https://9dd3bd9b7d01.ngrok.app/${path}`)
    }

    public Wait<WebDriver> getWait() {
        return wait;
    }
}
