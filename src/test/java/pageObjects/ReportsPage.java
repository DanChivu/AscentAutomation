package pageObjects;

import helper.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReportsPage extends Page {

    @FindBy (css = "a[href='/staff/reports']")
    WebElement reportsTab;
    @FindBy (xpath = "//*[@id=\"main-wrapper\"]/reports-list/components-list/div/link-ingot[1]/ingot/a")
    WebElement HHGReportShipmentButton;

    @FindBy (xpath = "//*[@id=\"main-wrapper\"]/hhg-shipment-history/k2-table/div[2]/div[3]/btn/button")
    WebElement runReportButton;

    @FindBy (id = "mat-select-6")
    WebElement clientDropdown;

    @FindBy (id="mat-select-8")
    WebElement partnerDropdown;
    @FindBy (id = "mat-select-10")
    WebElement serviceStatusDropdown;
    @FindBy (id = "mat-select-12")
    WebElement serviceManagerDropdown;

    @FindBy (id="mat-select-value-19")
    WebElement cityFromDropdown;
    @FindBy (id="mat-select-20")
    WebElement cityToDropdown;

    @FindBy (id="mat-select-22")
    WebElement officeLocationDropdown;
    @FindBy (id="mat-select-24")
    WebElement businessEntityDropdown;

    @FindBy (id="mat-select-0")
    WebElement serviceLevelDropdown;

    @FindBy (id="mat-select-2")
    WebElement productsDropdown;
    @FindBy (id="mat-select-4")
    WebElement assignmentStatusDropdown;

    @FindBy (xpath = "//*[@id=\"mat-select-14\"]")
    WebElement countryFromDropdown;
    @FindBy (id = "mat-select-16")
    WebElement countryToDropdown;

    public void selectCountry(String countryName, WebDriver driver, Page reportsPage) throws InterruptedException {


        PageFactory.initElements(driver, reportsPage);

        countryFromDropdown.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'" + countryName + "')]")).click();
        CommonElements.clickBottomRightCorner(driver);
        countryToDropdown.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + countryName + "')]")).click();
        CommonElements.clickBottomRightCorner(driver);
    }

    public void clickReportButton() {
        runReportButton.click();
    }

    public void clickReportsTab(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/staff/reports']")));
        reportsTab.click();
    }

    public void clickShipmentReports() {
        HHGReportShipmentButton.click();
    }
}
