package nicholas.allee.test.automation.framework.pageEvents;

import nicholas.allee.test.automation.framework.pageObjects.LoginPageElements;
import nicholas.allee.test.automation.framework.utilities.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {
    ElementFetch element  = new ElementFetch();
    public void verifyIfLoginPageIsLoaded(){
        Assert.assertTrue(element.getWebElements("XPATH", LoginPageElements.usernameField).size() > 0, "unable to locate username element inside login page.");
    }
    public void enterUsernamePassword(){
        element.getWebElement("XPATH", LoginPageElements.usernameField).sendKeys("");
    }

}
