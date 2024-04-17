package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.Page;

public class CommonElements {

    public void setDateMatCalendar(){
    }
    public By getMatCalendarElementByLabelText(String labelText) {
        return By.tagName("//mat-calendar//td/button[contains(@aria-label,"+labelText+")]");
    }
    public void clickMatCalendarElementByNumber(String labelText, int number, Page page) {

        page.findMatCalendarDate("10").click();
        page.click(this.getMatCalendarElementByLabelText(labelText));
    }
    public static void clickBottomRightCorner(WebDriver driver){
        Dimension size = driver.findElement(By.tagName("body")).getSize();
// Calculate the coordinates for the lower right diagonal
        int xOffset = (int) (size.getWidth() * 0.99);
        int yOffset = (int) (size.getHeight() * 0.99);
        Actions actions = new Actions(driver);
        actions.moveByOffset(xOffset, yOffset).click().perform();
    }
}
