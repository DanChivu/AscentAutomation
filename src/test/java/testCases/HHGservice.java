package testCases;

import helper.PassSignIn;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import pageObjects.InitiateAssignmentPage;
import pageObjects.LoginPage;
import pageObjects.Page;

import java.time.Duration;
import java.util.Date;

public class HHGservice extends Page {
    LoginPage loginPage = new LoginPage();
    InitiateAssignmentPage assignmentPage = new InitiateAssignmentPage();
    WebDriver driver = Page.getDriver();


    @Test
    public void initiateHHGService() throws InterruptedException {
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://dev.k2relo.com/staff/clients/330/assignments/new");
        loginPage.login();
        PageFactory.initElements(driver, assignmentPage);
        driver.get("https://dev.k2relo.com/staff/clients/330/assignments/new");
        assignmentPage.clickCloseButton();
        wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.getExistingAssigneeButton()));
        assignmentPage.selectAssignee();
        assignmentPage.clickNextButton();
        driver.findElement(By.cssSelector("body > app > flash-messages > p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-wrapper\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step2/div/form/div/initiation-nav-buttons/div/btn/button")));
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step2/div/form/div/initiation-nav-buttons/div/btn/button")).click();
        driver.findElement(By.cssSelector("body > app > flash-messages > p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#startDate")));
        driver.findElement(By.cssSelector("#startDate")).click();
        assignmentPage.findMatCalendarDate("12").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-datepicker-1")));
        driver.navigate().refresh();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mat-select-0")));
        assignmentPage.clickCloseButton();
        driver.findElement(By.cssSelector(("#mat-select-0"))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'United Kingdom')]")).click();
        driver.findElement(By.cssSelector("input[placeholder='Search city']")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"mat-option-1244\"]")).click();
        driver.findElement(By.id("mat-select-2")).click();
        driver.findElement(By.xpath("//mat-option/span[contains(text(), 'Romania')]")).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-option-text")));
        driver.findElement(By.cssSelector("input.mat-autocomplete-trigger.form-control.ng-valid.ng-dirty.ng-touched")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Bucuresti')]"))).click();
        driver.findElement(By.id("mat-select-12")).click();
        driver.findElement(By.xpath("//*[@aria-label='dropdown search']")).sendKeys("Romania");
        driver.findElement(By.xpath("//*[@placeholder='Search city']")).sendKeys("Bucuresti");
        driver.findElement(By.xpath("//*[@id=\"mat-option-3361\"]/span/location-autocomplete-option/autocomplete-option/div")).click();


        assignmentPage.clickNextButton();
    }
}
