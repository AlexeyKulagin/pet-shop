package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TailedManxCatPage extends HeaderComponent {

    @FindBy(linkText = "Add to Cart")
    WebElement addToCart;

    public TailedManxCatPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickAddToCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(addToCart)).click();

        return new CartPage(getDriver());
    }
}
