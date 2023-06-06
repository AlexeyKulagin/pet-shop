package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.HeaderComponent;

public class CartPage extends HeaderComponent {

    @FindBy(xpath = "//td/b")
    WebElement cartStatus;

    @FindBy(xpath = "//input[@name='updateCartQuantities']/..")
    WebElement subTotalStatus;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartStatus() {

        return getWait().until(ExpectedConditions.visibilityOf(cartStatus)).getText();
    }

//    public String getsubTotalStatus
//    WebElement subTotalStatus = getDriver().findElement(By.xpath("//input[@name='updateCartQuantities']/.."));

}
