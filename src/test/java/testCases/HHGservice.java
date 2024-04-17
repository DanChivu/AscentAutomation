package testCases;

import helper.CommonElements;
import helper.PassSignIn;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import pageObjects.InitiateAssignmentPage;
import pageObjects.LoginPage;
import pageObjects.Page;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HHGservice {
    LoginPage loginPage = new LoginPage();
    InitiateAssignmentPage assignmentPage = new InitiateAssignmentPage();
    WebDriver driver = Page.getDriver();
    LocalDate currentDate = LocalDate.now();

    @Test
    public void initiateHHGService() throws InterruptedException {
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        loginPage.login();
        PageFactory.initElements(driver, assignmentPage);
        driver.get("https://dev.k2relo.com/staff/clients/330/assignments/new");
        assignmentPage.clickCloseButton();
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(assignmentPage.getExistingAssigneeButton()));
        assignmentPage.selectAssignee();
        assignmentPage.clickNextButton();
        assignmentPage.dismissBanner();
        assignmentPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-wrapper\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step2/div/form/div/initiation-nav-buttons/div/btn/button")));
        assignmentPage.clickNextButton();
        assignmentPage.dismissBanner();
        assignmentPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#startDate")));
        driver.findElement(By.cssSelector("#startDate")).clear();
        driver.findElement(By.cssSelector("#startDate")).click();


        assignmentPage.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='"+ assignmentPage.selectDatePlusDays(currentDate, 2) +"']"))).click();
        if(driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/mat-calendar-header/div/div/button[1]/span[4]")).isDisplayed()){
            CommonElements.clickBottomRightCorner(driver);
        }
 //       driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr[4]/td[3]/button/span[1]")).click();
        //   driver.findElement(By.xpath("//button[@aria-label='April 20, 2024']")).click();
        assignmentPage.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(("#mat-select-10")))).click();
       // driver.findElement(By.cssSelector(("#mat-select-0"))).click();
        assignmentPage.inputOrigin();
        assignmentPage.inputDestination();
        Select assignmentType = new Select(driver.findElement(By.id("assignmentType")));
        assignmentType.selectByVisibleText("Permanent transfer (PT)");
        driver.findElement(By.id("mat-select-4")).click();
        assignmentPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-option")));
        driver.findElement(By.xpath("//mat-option/span[contains(text(), 'test')]")).click();
      /*  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-select-4")));
        Select clientContact = new Select(driver.findElement(By.id("mat-select-4")));
        clientContact.selectByVisibleText("test");*/
        driver.findElement(By.id("purchaseOrder")).sendKeys("11");
        driver.findElement(By.id("accountCode")).sendKeys("11");
        driver.findElement(By.id("companyCode")).sendKeys("11");
        driver.findElement(By.id("costCenter")).sendKeys("11");
        driver.findElement(By.id("clientAssignmentId")).sendKeys("11");
        driver.findElement(By.id("clientSystemEmployeeId")).sendKeys("11");
        driver.findElement(By.id("clientSystemEmployee")).sendKeys("11");
        assignmentPage.clickNextButton();

        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), 'HHG Shipment')]/input"));


        if (!checkbox.isSelected()) {
            checkbox.click();
            assignmentPage.clickNextButton();
            assignmentPage.clickNextButton();
        }
    }
}