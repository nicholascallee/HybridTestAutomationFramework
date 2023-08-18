import nicholas.allee.test.automation.framework.testBase.TestBase;
import nicholas.allee.test.automation.framework.utilities.CustomParams;
import org.testng.annotations.Test;

public class QATestOrangeHRM extends TestBase {

    @Test
    public void testLoginCredentials() throws InterruptedException {
        pageEventHolder.loginPageEvents.verifyIfLoginPageIsLoaded();
        pageEventHolder.loginPageEvents.enterUsernamePassword(customParams.username,customParams.password);
        pageEventHolder.loginPageEvents.clickSignInButton();
        Thread.sleep(1000L);
    }

}
