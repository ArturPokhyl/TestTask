package core.base;

import pages.PaymentPage;
import pages.SuccessPage;

public class PageBase {

    public PaymentPage payment() {
        return new PaymentPage();
    }

    public SuccessPage success() {
        return new SuccessPage();
    }
}
