package helper;

import org.openqa.selenium.By;
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
}
