package testCases;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.InitiateAssignmentPage;
import pageObjects.LoginPage;
import pageObjects.Page;
import pageObjects.ReportsPage;

import java.time.Duration;
import java.time.LocalDate;

public class Reports {

    LoginPage loginPage = new LoginPage();
    ReportsPage reportsPage = new ReportsPage();
    static WebDriver driver = Page.getDriver();
    LocalDate currentDate = LocalDate.now();

    @Test
    public void reportsTestAllResults() throws InterruptedException {
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        loginPage.login();
        PageFactory.initElements(driver, reportsPage);
        reportsPage.clickReportsTab();
        reportsPage.clickShipmentReports();
        Thread.sleep(1000);
        loginPage.clickCloseButton();
        reportsPage.clickReportButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ng-star-inserted")));
        Thread.sleep(1000);
        String spanText = spanElement.getText();
        spanText = spanText.substring(1, spanText.length() - 1); // This is to remove the parentheses
        int spanNumber = Integer.parseInt(spanText);
        if (spanNumber > 300) {
            System.out.println("Validation successful. The number is greater than 300.");
        } else {
            System.out.println("Validation failed. The number is not greater than 300.");
        }
    }
    @Test
    public void allFiltersApplied() throws InterruptedException {

        reportsPage.selectCountry("Peru", driver, reportsPage);

        System.out.println("Country selected successfully!");
    }
    @AfterAll
    public static void tearDown() {


        if (driver != null) {


            driver.quit();


        }
    }
}

