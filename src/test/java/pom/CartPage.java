package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends HeaderComponent {

    @FindBy(xpath = "//td/b")
    WebElement cartStatus;

    @FindBy(xpath = "//input[@name='updateCartQuantities']/..")
    WebElement subTotalStatus;

    @FindBy(xpath = "//td[4]")
    WebElement stockStatus;

    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartStatus() {

        return getWait().until(ExpectedConditions.visibilityOf(cartStatus)).getText();
    }

    public String getSubTotalStatus() {

        return subTotalStatus.getText();
    }

    public String getStockStatus() {

        return getWait().until(ExpectedConditions.visibilityOf(stockStatus)).getText();
    }

    public PaymentDetailsPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();

        return new PaymentDetailsPage(getDriver());
    }
}
