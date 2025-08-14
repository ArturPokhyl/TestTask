package pages;

import core.helpers.WebDriverHelper;

public class PageBase {
    protected WebDriverHelper driver() {
        return WebDriverHelper.driver();
    }
}
