import nicholas.allee.test.automation.framework.testBase.TestBase;
import org.testng.annotations.Test;

public class QATestOrangeHRM extends TestBase {

    @Test
    public void testLoginCredentials() throws InterruptedException {
        logger.info("Verifying that the loading page is loaded.");
        pageEventHolder.loginPageEvents.verifyIfLoginPageIsLoaded();
        logger.info("Entering username and password.");
        pageEventHolder.loginPageEvents.enterUsernamePassword(customParams.username,customParams.password);
        logger.info("Clicking Sign in Button.");
        pageEventHolder.loginPageEvents.clickSignInButton();
        Thread.sleep(1000L);
    }

}
