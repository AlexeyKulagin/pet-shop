package pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        }

        return wait;
    }
}
