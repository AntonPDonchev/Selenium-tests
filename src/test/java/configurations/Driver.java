package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;
import java.util.Set;

public class Driver implements WebDriver{
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Driver(String browserType) {
        switch (browserType) {
            case "Chrome":
                WebDriverManager.getInstance("Chrome").setup();
                driver.set(new ChromeDriver());
                break;
            case "IE":
                WebDriverManager.getInstance("IE").setup();
                driver.set(new InternetExplorerDriver());
                break;
            case "FireFox":
                WebDriverManager.getInstance("FireFox").setup();
                driver.set(new FirefoxDriver());
                break;
        }
        driver.get().manage().window().maximize();
    }
    public WebDriver getWebDriver(){
        return driver.get();
    }

//public class Driver implements WebDriver{

   // private static WebDriver driver = null;

  //  public static WebDriver getBrowser(String browserType) {

     //   if (driver == null) {

        //    if (browserType.equals("Chrome"))

          //  {

         //       driver = new ChromeDriver();

        //    } else if (browserType.equals("FireFox"))

        //    {

        //        driver = new FirefoxDriver();
//
       //     } else if (browserType.equals("IE"))

        //    {

         //       driver = new InternetExplorerDriver();
//
       //     }

       // } return driver;



    //}

    @Override
    public void get(String url) {
        getWebDriver().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getWebDriver().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    @Override
    public void close() {
        getWebDriver().close();

    }

    @Override
    public void quit() {
        getWebDriver().quit();

    }

    @Override
    public Set<String> getWindowHandles() {
        return getWebDriver().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getWebDriver().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return getWebDriver().switchTo();
    }

    @Override
    public Navigation navigate() {
        return getWebDriver().navigate();
    }

    @Override
    public Options manage() {
        return getWebDriver().manage();
    }
    public void loadBaseUrl(){
        String url = Configurations.readBaseUrl();
        getWebDriver().get(url);
    }
    public void killDriverSession(){
        close();
        driver=null;
    }

    //   public Driver(BrowserType browserType){
   //     System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\chromedri\\chromedriver-win64\\chromedriver-win64");
   //     if (browserType.equals(BrowserType.CHROME)){
   //         driver.set(new ChromeDriver());
  //      }else if (browserType.equals(BrowserType.IE)) {
  //          driver.set(new InternetExplorerDriver());
  //      }else if (browserType.equals(BrowserType.FIREFOX)) {
  //          driver.set(new FirefoxDriver());
  //      }else if (browserType.equals(BrowserType.OPERA)) {
   //         driver.set(new OperaDriver());
   //     }
   //     driver.get().manage().window().maximize();
  //  }
}
