package runner;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static List<String> elementsToStrings(List<WebElement> elements) {
        List<String> strings = new ArrayList<>();
        for (WebElement element : elements) {
            strings.add(element.getText());
        }

        return strings;
    }
}
