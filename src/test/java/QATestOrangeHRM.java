import nicholas.allee.test.automation.framework.testBase.TestBase;
import nicholas.allee.test.automation.framework.utilities.PageEventHolder;
import org.testng.annotations.Test;

public class QATestOrangeHRM extends TestBase {

    @Test
    public void testLoginCredentials() {
        pageEventHolder.loginPageEvents.enterUsernamePassword();
        pageEventHolder.loginPageEvents.clickSignInButton();
    }

}