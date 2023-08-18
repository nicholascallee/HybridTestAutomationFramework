package nicholas.allee.test.automation.framework.pageEvents;

import nicholas.allee.test.automation.framework.pageObjects.HomePageElements;
import nicholas.allee.test.automation.framework.pageObjects.LoginPageElements;
import nicholas.allee.test.automation.framework.utilities.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {
    ElementFetch element  = new ElementFetch();
    public void verifyIfLoginPageIsLoaded(){
        Assert.assertFalse(element.getWebElements("XPATH", LoginPageElements.usernameField).isEmpty(), "unable to locate username element inside login page.");
    }
    public void enterUsernamePassword(){
        element.getWebElement("XPATH", LoginPageElements.usernameField).sendKeys("");
        element.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys("");
    }

    public void clickSignInButton() throws InterruptedException {
        element.getWebElement("XPATH", LoginPageElements.loginButtonField).click();
    }

}
