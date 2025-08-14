package core.base;

import core.helpers.WebDriverHelper;
import core.helpers.api.ApiHelper;
import org.testng.annotations.AfterClass;

public class TestSuiteBase {

    protected WebDriverHelper driver() {
        return WebDriverHelper.driver();
    }

    protected PageBase page() {
        return new PageBase();
    }

    protected ApiHelper api() {
        return new ApiHelper();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownSuite() {
        WebDriverHelper.quit();
    }
}
