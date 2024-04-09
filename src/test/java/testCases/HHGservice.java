package testCases;

import helper.PassSignIn;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

        //*[@id="mat-datepicker-1"][@aria-label="April 8, 2024"]
        //*[@id="mat-datepicker-1"]/div/mat-month-view/table/tbody/tr[3]/td[3]/button/span[1]
        //*[@id="mat-datepicker-1"]/div/mat-month-view/table/tbody/tr[3]/td[4]/button/span[1]
        //*[@id="mat-datepicker-1"]/div/mat-month-view/table/tbody/tr[6]/td[2]/button/span[1]


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#startDate")));
        driver.findElement(By.cssSelector("#startDate")).click();
        loginPage.findMatCalendarDate("11").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-datepicker-1")));



        //mat-calendar//td/button[contains(@aria-label,"${labelText}")]

      /*
       Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("startDate")));
       driver.findElement(By.cssSelector("#mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(3) > td:nth-child(2) > button")).click();
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(2) > td.mat-calendar-body-label.ng-star-inserted
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(2) > td:nth-child(2) > button
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(1) > td:nth-child(2) > button
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(3) > td:nth-child(2) > button
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(3) > td:nth-child(3) > button
                #mat-datepicker-1 > div > mat-month-view > table > tbody > tr:nth-child(3) > td:nth-child(4) > button*/
        assignmentPage.clickNextButton();



    }
}
/*  assignmentPage.getTitleForm().sendKeys("Mr");
        assignmentPage.getFirstNameForm().sendKeys("Ivan");
        assignmentPage.getLastNameForm().sendKeys("Kravchenko");
        assignmentPage.getGenderDropdown().click();
        assignmentPage.getDoBInputField().sendKeys("Male");
        assignmentPage.getNationalityDropdown().sendKeys("Romanian");
        assignmentPage.getEmailField().sendKeys("ivanKravchenko@k2corporatemobility.com");
        assignmentPage.getMaritalStatusFieldDropdown().sendKeys("Single");
        assignmentPage.getDateOfBirthCalendar().sendKeys("3/3/1992");*/