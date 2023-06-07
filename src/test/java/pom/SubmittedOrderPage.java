package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubmittedOrderPage extends HeaderComponent {

    @FindBy(tagName = "li")
    WebElement orderSubmittedMessage;

    @FindBy(xpath = "//tr/th[contains(text(), 'Order')]")
    WebElement orderNumber;

    public SubmittedOrderPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderSubmittedMessage() {

        return getWait().until(ExpectedConditions.visibilityOf(orderSubmittedMessage)).getText();
    }

    public String getOrderNumber() {

        return orderNumber.getText().substring(7, 12);
    }
}
