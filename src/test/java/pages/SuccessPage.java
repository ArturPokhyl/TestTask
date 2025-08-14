package pages;

import static locators.SuccessPageLocators.*;

public class SuccessPage extends PageBase {

    public void waitForLoad() {
        driver().waitForVisibility(body);
        driver().waitForVisibility(imgSuccess);
        driver().waitForVisibility(txtTitle);
        driver().waitForVisibility(txtDescription);
        driver().waitForVisibility(txtPrice);
        driver().waitForVisibility(txtMethodTitle);
        driver().waitForVisibility(txtCardNumber);
        driver().waitForVisibility(imgCard);
    }
}
