package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    protected WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }

        return driver;
    }

    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        }

        return wait;
    }

    @BeforeMethod
    public void login() {
        getDriver().get("https://petstore.octoperf.com");
        getWait().until(ExpectedConditions.elementToBeClickable(By.tagName("a"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("qa");

        new Actions(getDriver())
                .click(getDriver().findElement(By.xpath("//input[@name='password']")))
                .keyDown(Keys.COMMAND)
                .sendKeys("A")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("test")
                .perform();

        getDriver().findElement(By.name("signon")).click();
    }

    @AfterMethod
    public void quiteDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
