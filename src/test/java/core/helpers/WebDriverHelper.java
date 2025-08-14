package core.helpers;

import core.ConfigReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public final class WebDriverHelper {

    private static final ThreadLocal<WebDriverHelper> TL = new ThreadLocal<>();
    private final WebDriver driver;
    private static final int implicitTimeout = Integer.parseInt(ConfigReader.getProperty("driver.properties", "implicit.timeout"));
    private static final int explicitTimeout = Integer.parseInt(ConfigReader.getProperty("driver.properties", "explicit.timeout"));

    private Logger log() {
        return LoggerHelper.log(this.getClass()).getLogger();
    }

    private void errorHandler(Throwable e, String comment) {
        throw new WebDriverException(comment + " Error -> " + e);
    }

    private WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriverHelper driver() {
        WebDriverHelper helper = TL.get();
        if (helper == null) {
            helper = init();
            TL.set(helper);
        }
        return helper;
    }

    public static void quit() {
        WebDriverHelper h = TL.get();
        if (h != null) {
            try {
                h.driver.quit();
            } finally {
                TL.remove();
            }
        }
    }

    private static WebDriverHelper init() {
        try {
            boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("driver.properties", "browser.headless"));
            ChromeOptions o = new ChromeOptions();
            if (headless) {
                o.addArguments("--headless=new");
            }
            WebDriver wd = new ChromeDriver(o);
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeout));
            wd.manage().window().maximize();
            return new WebDriverHelper(wd);
        } catch (Exception e) {
            throw new WebDriverException("Start browser Error -> " + e);
        }
    }

    public WebDriver webDriver() {
        return driver;
    }

    public void openURL(String url) {

        String description = "open URL => " + url;
        log().info(description);
        try {
            driver.get(url);
        } catch (Exception e) {
            this.errorHandler(e, description);
        }
    }

    private void waitForElementPresent(By locators) {
        String description = "waitForElementPresent => [" + locators.toString() + "]";
        log().info(description);
        try {
            WebDriverWait wait = new WebDriverWait(webDriver(), Duration.ofSeconds(explicitTimeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(locators));
        } catch (Exception e) {
            this.errorHandler(e, description);
        }
    }

    public WebElement findElement(By locator) {
        String description = "Find element by locator => [" + locator.toString() + "]";
        log().info(description);
        try {
            return webDriver().findElement(locator);
        } catch (Exception e) {
            this.errorHandler(e, description);
            return null;
        }
    }

    public void waitForVisibility(By locator) {
        String description = "WaitForVisibility " + locator;
        log().info(description);
        try {
            WebDriverWait wait = new WebDriverWait(webDriver(), Duration.ofSeconds(explicitTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            this.errorHandler(e, description);
        }
    }

    public void click(By locator) {
        String description = "Click to element by locator => [" + locator.toString() + "]";
        log().info(description);
        try {
            WebElement element = this.findElement(locator);
            WebDriverWait wait = new WebDriverWait(webDriver(), Duration.ofSeconds(explicitTimeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Objects.requireNonNull(element).click();
        } catch (Exception e) {
            this.errorHandler(e, description);
        }
    }

    public void sendKeys(By locator, String value) {
        String description = "Type a value => [" + value + "], locator => [" + locator.toString() + "]";
        log().info(description);
        try {
            this.waitForElementPresent(locator);
            Objects.requireNonNull(this.findElement(locator)).sendKeys(value);
        } catch (Exception e) {
            this.errorHandler(e, description);
        }
    }

    public void ajaxWait() {
        log().info("Ajax wait");
        try {
            long millis = Long.parseLong(ConfigReader.getProperty("driver.properties", "ajax.timeout"));
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAttribute(By locator, String attribute) {
        String description = "Get attribute " + attribute + ", locator => [" + locator.toString() + "]";
        log().info(description);
        try {
            return Objects.requireNonNull(this.findElement(locator)).getDomAttribute(attribute);
        } catch (Exception e) {
            this.errorHandler(e, description);
            return null;
        }
    }

    public String getText(By locator) {
        String description = "Get Text , locator => [" + locator.toString() + "]";
        try {
            String text = Objects.requireNonNull(this.findElement(locator)).getText();
            log().info("Text from element => {}", text);
            return text;
        } catch (Exception e) {
            this.errorHandler(e, description);
            return null;
        }
    }
}
