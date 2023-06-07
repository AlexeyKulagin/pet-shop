package pom;

import pom.base.HeaderComponent;
import runner.UtilTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OrdersPage extends HeaderComponent {

    @FindBy(css = "tbody>tr>td:first-child")
    List<WebElement> ordersListOfWebElements;

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getOrdersList() {

        return UtilTest.elementsToStrings(getWait().until(ExpectedConditions.visibilityOfAllElements(ordersListOfWebElements)));
    }
}
