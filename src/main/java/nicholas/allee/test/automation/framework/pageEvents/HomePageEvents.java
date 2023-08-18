package nicholas.allee.test.automation.framework.pageEvents;

import nicholas.allee.test.automation.framework.pageObjects.HomePageElements;
import nicholas.allee.test.automation.framework.pageObjects.LoginPageElements;
import nicholas.allee.test.automation.framework.utilities.ElementFetch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageEvents {
    ElementFetch element  = new ElementFetch();
    public void verifyIfUserWasLoggedIn(String validName){
        WebElement myWebElement = element.getWebElement("XPATH", HomePageElements.usernameDisplayText);
        String displayedName = myWebElement.getText();
        Assert.assertEquals(validName, displayedName);
    }
}
