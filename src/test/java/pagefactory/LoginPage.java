package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(linkText = "Register")
    private WebElement registerLink;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement userNameField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;
    @FindBy(id = "sign-in-button")
    private WebElement signInBtn;
    @FindBy(linkText = "remember Me")
    private WebElement rememberMe;
    @FindBy(xpath= "//div[contains(text(),'Wrong username or password!')]")
    private WebElement unsuccessfulLoginMsg;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }
    public void fillUserName(String userName){
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(userName);
    }
    public void fillPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn(){
        signInBtn.click();
    }
    public RegistrationPage clickRegister(){

        registerLink.click();
        RegistrationPage regPage = new RegistrationPage(driver);
        return regPage;
    }
    public void rememberMe(){
        rememberMe.click();
    }
    public WebElement getUnsuccessfulLoginMsg(){
        return unsuccessfulLoginMsg;
    }
}
