package testCases;

import helper.PassSignIn;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Page.openURL(Page.getDriver(), PassSignIn.getEnvironmentName(), "");
        loginPage.login();
        driver.get("https://dev.k2relo.com/staff/clients/238/assignments/new");
        PageFactory.initElements(driver, assignmentPage);
        assignmentPage.clickCloseButton();
        assignmentPage.selectAssignee();
        assignmentPage.clickNextButton();
        assignmentPage.getTitleForm().sendKeys("Mr");
        assignmentPage.getFirstNameForm().sendKeys("Ivan");
        assignmentPage.getLastNameForm().sendKeys("Kravchenko");
        assignmentPage.getGenderDropdown().click();

        assignmentPage.getDoBInputField().sendKeys("Male");
        assignmentPage.getNationalityDropdown().sendKeys("Romanian");
        assignmentPage.getEmailField().sendKeys("ivanKravchenko@k2corporatemobility.com");
        assignmentPage.getMaritalStatusFieldDropdown().sendKeys("Single");
        assignmentPage.getDateOfBirthCalendar().sendKeys("3/3/1992");
    }
}
