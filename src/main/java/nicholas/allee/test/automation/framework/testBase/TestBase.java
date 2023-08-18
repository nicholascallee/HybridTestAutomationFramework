package nicholas.allee.test.automation.framework.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import nicholas.allee.test.automation.framework.utilities.Constants;
import nicholas.allee.test.automation.framework.utilities.CustomParams;
import nicholas.allee.test.automation.framework.utilities.PageEventHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    public CustomParams customParams;
    public PageEventHolder pageEventHolder;

    @BeforeClass
    public void beforeClass() throws IOException {
        customParams = new CustomParams();
        pageEventHolder = new PageEventHolder();
    }

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
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
            driver = new EdgeDriver();
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
    if(result.getStatus() == ITestResult. FAILURE) {
        logger.log (Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor. RED));
        logger.log (Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " Test Case Failed", ExtentColor.RED));
    }
    else if(result.getStatus() == ITestResult.SKIP) {
        logger.log (Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor. ORANGE));
    }
    else if(result.getStatus() == ITestResult.SUCCESS) {
        logger.log (Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASS", ExtentColor.GREEN));
    }
    driver.quit();
    }

    @AfterTest
    public void afterTest(){
        extent.flush();
    }
}

