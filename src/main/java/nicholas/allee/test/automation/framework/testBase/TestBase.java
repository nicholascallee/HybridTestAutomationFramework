package nicholas.allee.test.automation.framework.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.File;
import java.lang.reflect.Method;

public class TestBase {
    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void beforeTest()
    {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+ File.separator+"AlleeExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter (sparkReporter);
        sparkReporter.config().setTheme (Theme. DARK);
        extent.setSystemInfo("HostName", "RHEL8");
        extent.setSystemInfo("UserName", "root");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Tests Results by Nicholas Allee");
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser, Method testMethod){
        logger = extent.createTest(testMethod.getName());
        setupDriver(browser);
    }

    public void setupDriver (String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterMethod
    public void afterMethod(){

    }
    @AfterTest
    public void afterTest(){

    }
}

