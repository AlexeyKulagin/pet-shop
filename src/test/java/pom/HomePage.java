package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends HeaderComponent {

    @FindBy(id = "WelcomeContent")
    WebElement welcomeMessage;

    @FindBy(xpath = "//area[@alt='Cats']")
    WebElement catsPicLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomeUrl() {

        return getWait().until(ExpectedConditions.refreshed(
                webDriver -> webDriver != null ? webDriver.getCurrentUrl() : null));
    }

    public String getWelcomeMessage() {

        return welcomeMessage.getText();
    }

    public CatsPage clickCatsPicLink() {
        getWait().until(ExpectedConditions.elementToBeClickable(catsPicLink)).click();

        return new CatsPage(getDriver());
    }
}
