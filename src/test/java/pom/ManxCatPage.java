package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManxCatPage extends HeaderComponent {

    @FindBy(linkText = "EST-15")
    WebElement tailedManxCatLink;

    public ManxCatPage(WebDriver driver) {
        super(driver);
    }

    public TailedManxCatPage clickTailedManxCatLink() {
        getWait().until(ExpectedConditions.elementToBeClickable(tailedManxCatLink)).click();

        return new TailedManxCatPage(getDriver());
    }
}
