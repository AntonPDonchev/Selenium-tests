package tests;

import configurations.Configurations;
import configurations.Driver;
import helpers.FileHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
   // protected WebDriver driver;
    protected String username;
    protected String password;
    protected String url;
    private ThreadLocal<Driver> driver = new ThreadLocal<>();

    protected Driver getDriver(){
        return driver.get();
    }
    private String browserType;
//4.19.1

    @BeforeMethod
    void setup(){
       // driver=new ChromeDriver();

       // driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.get(url);
        driver.set(new Driver(browserType));
        getDriver().loadBaseUrl();
    }

    @BeforeTest
    void beforeTest()throws IOException{
        Configurations.loadConfigurations();

    }

    @BeforeClass
    void beforeClass() throws IOException {
        username = Configurations.readUserName();
        password = Configurations.readPass();
        url=Configurations.readBaseUrl();
        FileHelpers.cleanUpDirectory();
        browserType=Configurations.readBrowserType();

    }
    @AfterMethod
            void cleanUp(ITestResult result) throws IOException{
        if (result.getStatus()==ITestResult.FAILURE){
            FileHelpers.takeScreenshot(getDriver().getWebDriver(),result);
        }
        getDriver().killDriverSession();
    }
}
