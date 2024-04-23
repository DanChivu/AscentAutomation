package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditNeedsAnalysis {

    //https://dev.k2relo.com/staff/clients/330/assignment/33015/analysis?tab=hhg_shipment

    @FindBy(xpath = "//*[@id=\"assignment-need-analysis\"]/assignment-analysis-answers/simple-tabs/ul/li[7]/a")
    WebElement houseHoldShipmentTabl;

    @FindBy(xpath = "//*[@id=\"assignment-need-analysis\"]/assignment-analysis-answers/simple-tabs/simple-tab[7]/div/div/div/div[1]/btn/button")
    WebElement editButton;

}
