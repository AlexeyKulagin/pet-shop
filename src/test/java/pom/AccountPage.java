package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.HeaderComponent;

public class AccountPage extends HeaderComponent {

    @FindBy(linkText = "My Orders")
    WebElement myOrdersLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public OrdersPage clickMyOrdersLink() {
        getWait().until(ExpectedConditions.elementToBeClickable(myOrdersLink)).click();
        return new OrdersPage(getDriver());
    }
}
