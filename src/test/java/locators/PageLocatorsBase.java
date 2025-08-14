package locators;

import org.openqa.selenium.By;


public class PageLocatorsBase {

    public static By byTestId(String id) {
        return By.xpath("//*[@data-testid='" + id + "']");
    }

    public static By byTestId(String tag, String id) {
        return By.xpath("//" + tag + "[@data-testid='" + id + "']");
    }
}
