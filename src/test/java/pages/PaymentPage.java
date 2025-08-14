package pages;


import core.data_models.Card;
import org.testng.TestException;

import java.util.Objects;

import static locators.PaymentPageLocators.*;

public class PaymentPage extends PageBase {

    public void waitForLoad() {
        driver().waitForVisibility(pageForm);
        driver().waitForVisibility(inputCardNumber);
        driver().waitForVisibility(inputCardExpiryDate);
        driver().waitForVisibility(inputCardCvv);
        driver().waitForVisibility(inputCardHolder);
        driver().waitForVisibility(checkboxTerms);
        driver().waitForVisibility(btnSubmit);
    }

    public void setCard(Card card) {
        driver().sendKeys(inputCardNumber, card.getNumber());
        driver().sendKeys(inputCardExpiryDate, card.getExpiryDate());
        driver().sendKeys(inputCardCvv, card.getCvv());
        driver().sendKeys(inputCardHolder, card.getHolder());
        driver().ajaxWait();
    }

    public void clickSubmit() {
        driver().click(btnSubmit);
    }

    public void setTermsChecked(boolean isChecker) {
        if (Boolean.parseBoolean(driver().getAttribute(checkboxTerms, "aria-checked")) != isChecker)
            driver().click(checkboxTerms);
    }

    public int getAmount() {
        return Integer.parseInt(Objects.requireNonNull(driver().getText(txtPrice)).split(" ")[0].replace(",", ""));
    }

    public String getCurrency() {
        String text = Objects.requireNonNull(driver().getText(txtPrice)).split(" ")[1];
        return switch (text) {
            case "€" -> "EUR";
            case "$" -> "USD";
            default -> throw new TestException("Unknown currency");
        };
    }
}
