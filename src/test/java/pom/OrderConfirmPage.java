package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmPage extends HeaderComponent {

    @FindBy(linkText = "Confirm")
    WebElement confirmButton;

    public OrderConfirmPage(WebDriver driver) {
        super(driver);
    }

    public SubmittedOrderPage clickConfirmButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(confirmButton)).click();

        return new SubmittedOrderPage(getDriver());
    }
}
