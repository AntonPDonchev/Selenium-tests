package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pagefactory.HeaderPage;
import pagefactory.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest{

 //   /@Test
//    public void login() {


//        WebElement loginElement = driver.findElement(By.xpath("//a[text()='Login']"));
//        loginElement.click();
//        WebElement userName = driver.findElement(By.id("defaultLoginFormUsername"));
 //       userName.sendKeys("username1714125608");
//        WebElement pass = driver.findElement(By.id("defaultLoginFormPassword"));
//        pass.sendKeys("Test1234");
//        WebElement signIn = driver.findElement(By.id("sign-in-button"));
//        signIn.click();

//        WebElement homeElement = driver.findElement(By.xpath("//a[text()='Home']"));
 //       List<WebElement> posts = (List<WebElement>) driver.findElement(By.xpath("//*[@class='post-feed-img']"));
 //       System.out.println(posts.size());
 //       Assert.assertEquals(posts.size(), 3);

  //  }
    @Test
    public void successfulLogin(){
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginBtn();
    }
    @Test
    public void UnsuccessfulLogin() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        LoginPage loginPage = headerPage.clickLogin();
        loginPage.fillUserName("ahjahfzxvbc");
        loginPage.fillPassword("gasdzxcfds1");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.getUnsuccessfulLoginMsg().isDisplayed());
    }
}
