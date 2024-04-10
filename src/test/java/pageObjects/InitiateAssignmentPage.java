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

    public void selectAssignee() {
        existingAssigneeButton.click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type=\"submit\"]")));
        nextButton.click();
    }
}
