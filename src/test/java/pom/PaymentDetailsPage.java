package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentDetailsPage extends HeaderComponent {

    @FindBy(name = "newOrder")
    WebElement continueButton;

    public PaymentDetailsPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmPage clickContinueButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        return new OrderConfirmPage(getDriver());
    }
}
