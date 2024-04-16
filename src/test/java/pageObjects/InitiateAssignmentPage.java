package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InitiateAssignmentPage extends Page {


    @FindBy(xpath = "//*[@id=\"main-wrapper\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step1/div/form/fieldset/div/div/label[2]/input")
    WebElement existingAssigneeButton;

    public WebElement getDoBInputField() {
        return doBInputField;
    }

    @FindBy(xpath = "//*[@id=\"mat-option-151\"]/span/ngx-mat-select-search/div/input")
    WebElement doBInputField;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\\\"main-wrapper\\\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step2/div/form/div/initiation-nav-buttons/div/btn/button")
    WebElement nextButton2;

    public void inputDate(){

    }
    public WebElement getTitleForm() {
        return titleForm;
    }

    public WebElement getFirstNameForm() {
        return firstNameForm;
    }

    public WebElement getLastNameForm() {
        return lastNameForm;
    }

    public WebElement getGenderDropdown() {
        return genderDropdown;
    }

    public WebElement getNationalityDropdown() {
        return nationalityDropdown;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getMaritalStatusFieldDropdown() {
        return maritalStatusFieldDropdown;
    }

    public WebElement getDateOfBirthCalendar() {
        return dateOfBirthCalendar;
    }

    @FindBy(xpath = "//*[@id=\"title\"]")
    WebElement titleForm;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    WebElement firstNameForm;
    @FindBy(xpath = "//*[@id=\"lastName\"]")
    WebElement lastNameForm;
    @FindBy(xpath = "//*[@id=\"mat-select-2\"]/div")
    WebElement genderDropdown;
    @FindBy(xpath = "//*[@id=\"mat-select-value-5\"]")
    WebElement nationalityDropdown;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailField;
    @FindBy(xpath = "//*[@id=\"mat-select-6\"]")
    WebElement maritalStatusFieldDropdown;
    @FindBy(xpath = "//*[@id=\"dob\"]")
    WebElement dateOfBirthCalendar;

    public WebElement getExistingAssigneeButton() {
        return existingAssigneeButton;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getOriginCountryDropdown() {
        return originCountryDropdown;
    }

    @FindBy(xpath = "//*[@id=\"mat-select-12\"]")
    WebElement originCountryDropdown;

    @FindBy(css = "body > app > flash-messages > p")
    WebElement notificationBanner;

    public void dismissBanner(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > app > flash-messages > p")));
        notificationBanner.click();
    }
    public void selectAssignee() {
        existingAssigneeButton.click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type=\"submit\"]")));
        nextButton.click();
    }

    public void inputOrigin() {
        driver.findElement(By.xpath("//span[contains(text(), 'United Kingdom')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Search city']"))).sendKeys("London");
      //  driver.findElement(By.xpath("input[placeholder='Search city']")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"mat-option-1244\"]")).click();

    }

    public void inputDestination() {
        driver.findElement(By.id("mat-select-2")).click();
        driver.findElement(By.xpath("//mat-option/span[contains(text(), 'Romania')]")).click();
        driver.findElement(By.cssSelector("input.mat-autocomplete-trigger.form-control.ng-valid.ng-dirty.ng-touched")).click();
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/client/div[2]/client-profile/tabs/div[2]/new-assignment/div/new-assignment-step3/div/form/fieldset/div[1]/locations-selector-control[2]/locations-selector")).click();
        try {
            driver.findElement(By.cssSelector("input.mat-autocomplete-trigger.form-control.ng-pristine.ng-valid.ng-touched")).sendKeys("Bucharest");

        }catch (Exception e){
            driver.findElement(By.cssSelector("#main-wrapper > client > div.content > client-profile > tabs > div.tabs-content > new-assignment > div > new-assignment-step3 > div > form > fieldset > div:nth-child(2) > locations-selector-control:nth-child(5) > locations-selector > autocomplete-selector > div > input")).sendKeys("Bucharest");

        }

        driver.findElement(By.xpath("//*[@id=\"mat-option-1739\"]")).click();
    }
}
