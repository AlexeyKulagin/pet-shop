import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pom.AccountPage;
import pom.HomePage;
import pom.OrdersPage;
import runner.BaseTest;
import runner.UtilTest;

import java.util.List;

public class MakeOrderTest extends BaseTest {

    @Test
    public void testMakeOrder() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(homePage.getHomeUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome Alex!");

        List<String> oldOrderList = homePage.clickMyAccountLink()
                .clickMyOrdersLink()
                .getOrdersList();

        String cartStatus = new OrdersPage(getDriver()).clickCartLink().getCartStatus();

        Assert.assertEquals(cartStatus, "Your cart is empty.");

        WebElement subTotalStatus = getDriver().findElement(By.xpath("//input[@name='updateCartQuantities']/.."));
        Assert.assertEquals(subTotalStatus.getText(), "Sub Total: $0.00");

        getDriver().findElement(By.id("BackLink")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//area[@alt='Cats']"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("FL-DSH-01"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("EST-15"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Add to Cart"))).click();

        Assert.assertEquals(getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[4]"))).getText(), "true");
        getDriver().findElement(By.linkText("Proceed to Checkout")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.name("newOrder"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Confirm"))).click();

        Assert.assertEquals(getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("li"))).getText(), "Thank you, your order has been submitted.");

        String orderNumber = getDriver().findElement(By.xpath("//tr/th[contains(text(), 'Order')]"))
                .getText().substring(7, 12);

        getDriver().findElement(By.linkText("My Account")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("My Orders"))).click();

        List<WebElement> newOrderOfElements = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("tbody>tr>td:first-child")));
        List<String> newOrderList = UtilTest.elementsToStrings(newOrderOfElements);

        Assert.assertFalse(oldOrderList.contains(orderNumber), "Old Order list contains Order #:" + orderNumber);
        Assert.assertTrue(newOrderList.contains(orderNumber), "New Order list doesn't contain Order #:" + orderNumber);
        Assert.assertEquals(newOrderList.size() - oldOrderList.size(), 1);
    }
}
