package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagefactory.HeaderPage;
import pagefactory.LoginPage;
import pagefactory.RegistrationPage;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class RegistrationTest extends BaseTest{

    @DataProvider(name = "Registration Date")
    public Object[][] registrationData() {
        return new Object[][]{{
                "", "test@gmail.com", "03211984", "Test123", "Test123", "Test Info"
        },
                {
                        "TestUser", "", "03211984", "Test123", "Test123", "Test Info"
                },
                {
                        "TestUser", "test@gmail.com", "", "Test123", "Test123", "Test Info"
                },
                {
                        "TestUser", "test@gmail.com", "03211984", "", "Test123", "Test Info"
                },
                {
                        "TestUser", "test@gmail.com", "03211984", "Test123", "", "Test Info"
                },
                {
                        "TestUser", "test@gmail.com", "03211984", "Test123", "Test123", ""
                }
            };
    }

    @Test
    public void register() {


    //    WebElement loginElement = driver.findElement(By.id("nav-link-login"));
    //    loginElement.click();
    //    WebElement register = driver.findElement(By.linkText("Register"));
    //    register.click();
     //   WebElement userName = driver.findElement(By.name("username"));
    //    long timestamp = Instant.now().getEpochSecond();
    //    userName.sendKeys("username"+timestamp);
    //    WebElement email = driver.findElement(By.cssSelector("input[placeholder='email']"));
     //   email.sendKeys(timestamp+"@test.net");
    //    WebElement birthDate = driver.findElement(By.cssSelector("input[placeholder='Birth date']"));
    //    birthDate.sendKeys("12/20/1980");
    //    WebElement password = driver.findElement(By.name("password"));
    //    password.sendKeys("Test1234");
    //    WebElement confirmPassword = driver.findElement(By.name("verify-password"));
     //   confirmPassword.sendKeys("Test1234");
    //    WebElement publicinfo = driver.findElement(By.name("pulic-info"));
    //    publicinfo.sendKeys("test");
   //     WebElement siggnIn = driver.findElement(By.id("sign-in-button"));
    //    siggnIn.click();


    }
    @Test
    public void successfulRegistration(){
        long timestamp = Instant.now().getEpochSecond();
        String userName = "testUser_"+timestamp;
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        RegistrationPage regPage = loginPage.clickRegister();
        regPage.fillUserName(userName);
        regPage.fillEmail(timestamp+"@test.com");
        regPage.fillDate("12201980");
        regPage.fillPassword("Test1234");
        regPage.fillRepeatPassword("Test1234");
        regPage.fillPublicInfo("Public info.");
        regPage.clickSignInBtn();

    }
    @Test
    public void clickFollow() {
        WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginBtn();
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[text()='Follow']"))));
        List<WebElement>followBtns = getDriver().findElements(By.xpath("//button[text()='Follow']"));
        for (WebElement followBtn : followBtns){
            followBtn.click();
        }
    }

    @Test
    public void UnsuccessfulRegistrationUserNameTaken() {
        long timestamp = Instant.now().getEpochSecond();
        String userName = "testUser_";
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        RegistrationPage regPage = loginPage.clickRegister();
        regPage.fillUserName(userName);
        regPage.fillEmail(timestamp + "@test.com");
        regPage.fillDate("12201980");
        regPage.fillPassword("Test1234");
        regPage.fillRepeatPassword("Test1234");
        regPage.fillPublicInfo("Public info.");
        regPage.clickSignInBtn();
        Assert.assertTrue(regPage.getUserNameTakenMsg().isDisplayed());
    }
    @Test
    public void registrationIsNotPossibleWhenSomeOfTheFieldsIsEmpty() {
        long timestamp = Instant.now().getEpochSecond();
        String userName = "testUser_";
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        RegistrationPage regPage = loginPage.clickRegister();
        regPage.fillUserName(userName);
        regPage.fillEmail(timestamp + "@test.com");
        //regPage.fillDate("12201980");
        regPage.fillPassword("Test1234");
        regPage.fillRepeatPassword("Test1234");
        regPage.fillPublicInfo("Public info.");
        regPage.clickSignInBtn();
        Assert.assertFalse(regPage.getSignInBtn().isEnabled());
    }
    @Test(dataProvider = "Registration Date")
    public void registrationIsNotPossibleWhenSomeOfTheFieldsIsEmptyUsingDataProvider(String userName, String email,String dateOfBirth, String pass, String confirmPass, String publicInfo) {
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        RegistrationPage regPage = loginPage.clickRegister();
        regPage.fillUserName(userName);
        regPage.fillEmail(email);
        regPage.fillDate(dateOfBirth);
        regPage.fillPassword(pass);
        regPage.fillRepeatPassword(confirmPass);
        regPage.fillPublicInfo(publicInfo);
        regPage.clickSignInBtn();
        Assert.assertFalse(regPage.getSignInBtn().isEnabled());
    }
    @Test(dataProvider = "Registration Date")
    public void fieldValidationMsgAppearsForAllFields (String userName, String email,String dateOfBirth, String pass, String confirmPass, String publicInfo) {
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        RegistrationPage regPage = loginPage.clickRegister();
        regPage.fillUserName(userName);
        regPage.fillEmail(email);
        regPage.fillDate(dateOfBirth);
        regPage.fillPassword(pass);
        regPage.fillRepeatPassword(confirmPass);
        regPage.fillPublicInfo(publicInfo);
        regPage.clickSignInBtn();
        Assert.assertFalse(regPage.getValidationMsg1().isDisplayed());
    }

}