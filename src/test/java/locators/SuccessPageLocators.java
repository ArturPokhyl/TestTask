package locators;

import org.openqa.selenium.By;

public class SuccessPageLocators extends PageLocatorsBase {

    public static final By body = By.xpath("//div[contains(@class, 'StatusSuccess_root')]");
    public static final By imgSuccess = By.xpath("//div[contains(@class, 'StatusSuccess_image_')]");
    public static final By txtTitle = byTestId("status-title");
    public static final By txtDescription = byTestId("status-order-description");
    public static final By txtPrice = byTestId("status-order-price-header");
    public static final By txtMethodTitle = byTestId("status-payment-method-title");
    public static final By txtCardNumber = byTestId("status-payment-method-card-number");
    public static final By imgCard = byTestId("status-payment-method-image-card");

}
