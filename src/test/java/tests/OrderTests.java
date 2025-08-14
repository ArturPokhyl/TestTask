package tests;

import core.base.TestSuiteBase;
import core.data_models.Card;
import core.data_models.StatusResponse;
import core.helpers.JsonFileHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTests extends TestSuiteBase {

    @Test
    public void successPaymentTest() {
        String createPaymentPage = JsonFileHelper.readJsonFileAsString("src/test/resources/create_payment_page_request.json");
        driver().openURL(api().createPaymentPage(createPaymentPage).getUrl());
        page().payment().waitForLoad();
        page().payment().setCard(Card.getDefaultCard());
        page().payment().setTermsChecked(true);
        int amount = page().payment().getAmount();
        String currency = page().payment().getCurrency();
        page().payment().clickSubmit();
        page().success().waitForLoad();
        String status_request = JsonFileHelper.readJsonFileAsString("src/test/resources/status_request.json");
        StatusResponse status = api().getStatus(status_request);
        String transactionId = status.getTransactions().keySet().iterator().next();
        StatusResponse.Transaction transaction = status.getTransactions().get(transactionId);
        Assert.assertEquals(transaction.getStatus(), "success");
        Assert.assertEquals(transaction.getAmount(), amount);
        Assert.assertEquals(transaction.getCurrency(), currency);
    }

}
