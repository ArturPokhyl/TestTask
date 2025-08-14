package locators;

import org.openqa.selenium.By;

public class PaymentPageLocators extends PageLocatorsBase {

    public static final By pageForm = By.xpath("//main[contains(@class, 'PaymentPage_form')]");
    public static final By inputCardNumber = byTestId("input", "cardNumber");
    public static final By inputCardExpiryDate = byTestId("input", "cardExpiryDate");
    public static final By inputCardCvv = byTestId("input", "cardCvv");
    public static final By inputCardHolder = byTestId("input", "cardHolder");
    public static final By checkboxTerms = byTestId("terms-checkbox");
    public static final By btnSubmit = byTestId("button", "submit");
    public static final By txtPrice = byTestId("price_major");

}
