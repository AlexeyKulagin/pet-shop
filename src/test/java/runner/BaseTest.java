package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriverWait getWait(long seconds) {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        }
        return wait;
    }

    @BeforeMethod
    public void login() {
        getDriver().get("https://petstore.octoperf.com");
        getWait(2).until(ExpectedConditions.elementToBeClickable(By.tagName("a"))).click();
        getWait(2).until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))).click();
        getWait(2).until(ExpectedConditions.elementToBeClickable(By.name("username")))
                .sendKeys("qa");
        WebElement passwdField = getDriver().findElement(By.xpath("//input[@name='password']"));
        passwdField.clear();
        passwdField.sendKeys("test");
        getDriver().findElement(By.name("signon")).click();
    }

    @AfterMethod
    public void quiteDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
