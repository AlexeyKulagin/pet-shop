package pom;

import pom.base.HeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatsPage extends HeaderComponent {

    @FindBy(linkText = "FL-DSH-01")
    WebElement manxCat;

    public CatsPage(WebDriver driver) {
        super(driver);
    }

    public ManxCatPage clickManxCat() {
        getWait().until(ExpectedConditions.elementToBeClickable(manxCat)).click();

        return new ManxCatPage(getDriver());
    }
}
