package pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.AccountPage;
import pom.CartPage;

public abstract class HeaderComponent extends BasePage {

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(name = "img_cart")
    WebElement cartLink;

    protected HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickMyAccountLink() {
        myAccountLink.click();

        return new AccountPage(getDriver());
    }

    public CartPage clickCartLink() {
        cartLink.click();

        return new CartPage(getDriver());
    }
}
