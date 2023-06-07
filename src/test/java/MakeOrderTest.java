import org.testng.Assert;
import org.testng.annotations.Test;

import pom.CartPage;
import pom.HomePage;
import pom.OrdersPage;
import pom.SubmittedOrderPage;
import runner.BaseTest;

import java.util.List;

public class MakeOrderTest extends BaseTest {

    @Test
    public void testMakeOrder() {

        HomePage homePage = new HomePage(getDriver());

        Assert.assertEquals(homePage.getHomeUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome Alex!");

        List<String> oldOrdersList = homePage
                .clickMyAccountLink()
                .clickMyOrdersLink()
                .getOrdersList();

        CartPage cartPage = new OrdersPage(getDriver()).clickCartLink();

        Assert.assertEquals(cartPage.getCartStatus(), "Your cart is empty.");
        Assert.assertEquals(cartPage.getSubTotalStatus(), "Sub Total: $0.00");

        String stockStatus = cartPage
                .clickLogo()
                .clickCatsPicLink()
                .clickManxCat()
                .clickTailedManxCatLink()
                .clickAddToCart()
                .getStockStatus();

        Assert.assertEquals(stockStatus, "true");

        SubmittedOrderPage submittedOrderPage = new CartPage(getDriver())
                .clickProceedToCheckoutButton()
                .clickContinueButton()
                .clickConfirmButton();

        Assert.assertEquals(submittedOrderPage.getOrderSubmittedMessage(), "Thank you, your order has been submitted.");

        String orderNumber = submittedOrderPage.getOrderNumber();

        List<String> newOrderList = submittedOrderPage
                .clickMyAccountLink()
                .clickMyOrdersLink()
                .getOrdersList();

        Assert.assertFalse(oldOrdersList.contains(orderNumber), "Old Order list should not contain the Order #:" + orderNumber);
        Assert.assertTrue(newOrderList.contains(orderNumber), "New Order list doesn't contain Order #:" + orderNumber);
        Assert.assertEquals(newOrderList.size() - oldOrdersList.size(), 1);
    }
}
