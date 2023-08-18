import nicholas.allee.test.automation.framework.testBase.TestBase;
import org.testng.annotations.Test;

public class QATestOrangeHRM extends TestBase {

    @Test
    public void testLoginCredentials() throws InterruptedException {
        pageEventHolder.loginPageEvents.verifyIfLoginPageIsLoaded();
        pageEventHolder.loginPageEvents.enterUsernamePassword();
        pageEventHolder.loginPageEvents.clickSignInButton();
    }

}
