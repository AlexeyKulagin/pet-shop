package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.HeaderComponent;

public class HomePage extends HeaderComponent {

    @FindBy(id = "WelcomeContent")
    WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomeUrl() {
//        getWait().until(ExpectedConditions.refreshed(getDriver().getCurrentUrl()));
//        getWait().until(ExpectedConditions.refreshed(WebDriver::getCurrentUrl));

        return getWait().until(ExpectedConditions.refreshed(
                webDriver -> webDriver != null ? webDriver.getCurrentUrl() : null));
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
