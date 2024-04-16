package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Page {

    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/tasks-list-dialog/mat-dialog-actions/btn/button")
    WebElement closeButton;

    public void clickCloseButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mat-dialog-0\"]/tasks-list-dialog/mat-dialog-actions/btn/button")));
        closeButton.click();
    }

    //.addArguments("--headless=new").addArguments("--start-maximized"); add or remove headless from the instantiation here
    static ChromeOptions options = new ChromeOptions();

    static WebDriver driver = new ChromeDriver(options);


    public static WebDriver getDriver() {
        return driver;
    }

    public static ChromeOptions getOptions() {
        return options;
    }

    public Wait<WebDriver> wait =
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);

    public static void openURL(WebDriver driver, String environmentName, String path) {
        driver.get("https://" + environmentName + ".k2relo.com/" + path);
        // await browser.url(`https://9dd3bd9b7d01.ngrok.app/${path}`)
    }

    public WebElement findMatCalendarDate(String requiredDate) {
        return driver.findElement(By.xpath("//mat-calendar//td/button[contains(@aria-label," + requiredDate + ")]"));
    }

    public void click(By elementLocator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated((elementLocator)));
        driver.findElement(elementLocator).click();
    }

    public String selectDate(LocalDate date) {


        String day = String.valueOf(date.getDayOfMonth());

        String month = date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());

        String year = String.valueOf(date.getYear());

        return STR."\{month} \{day}, \{year}";


    }


    public String selectDatePlusDays(LocalDate date, int daysToAdd) {

        LocalDate newDate = date.plusDays(daysToAdd);

        String day = String.valueOf(newDate.getDayOfMonth());

        String month = newDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.US);

        String year = String.valueOf(newDate.getYear());

        return month + " " + day + ", " + year;

    }

    public Wait<WebDriver> getWait() {
        return wait;
    }
}
