package pom.base;

import pom.AccountPage;
import pom.CartPage;
import pom.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class HeaderComponent extends BasePage {

    @FindBy(xpath = "//a[@href='/actions/Catalog.action']")
    WebElement logo;

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(name = "img_cart")
    WebElement cartLink;

    protected HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLogo(){
        logo.click();

        return new HomePage(getDriver());
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
