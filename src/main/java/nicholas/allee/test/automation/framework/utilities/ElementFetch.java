package nicholas.allee.test.automation.framework.utilities;

import nicholas.allee.test.automation.framework.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue){
        return switch (identifierType) {
            case "XPATH" -> TestBase.driver.findElement(By.xpath(identifierValue));
            case "CSS" -> TestBase.driver.findElement(By.cssSelector(identifierValue));
            case "ID" -> TestBase.driver.findElement(By.id(identifierValue));
            case "NAME" -> TestBase.driver.findElement(By.name(identifierValue));
            case "TAGNAME" -> TestBase.driver.findElement(By.tagName(identifierValue));
            default -> null;
        };
    }
    public List<WebElement> getWebElements(String identifierType, String identifierValue){
        return switch (identifierType) {
            case "XPATH" -> TestBase.driver.findElements(By.xpath(identifierValue));
            case "CSS" -> TestBase.driver.findElements(By.cssSelector(identifierValue));
            case "ID" -> TestBase.driver.findElements(By.id(identifierValue));
            case "NAME" -> TestBase.driver.findElements(By.name(identifierValue));
            case "TAGNAME" -> TestBase.driver.findElements(By.tagName(identifierValue));
            default -> null;
        };
    }
}
