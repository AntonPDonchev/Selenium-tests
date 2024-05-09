package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement userName;
    @FindBy(xpath = "//div[contains(text(),'Username taken')]")
    private WebElement userNameTakenMsg;
    @FindBy(css= "input[placeholder='email']")
    private WebElement email;
    @FindBy(css= "input[placeholder='Birth date']")
    private WebElement date;
    @FindBy(name= "password")
    private WebElement password;
    @FindBy(name= "verify-password")
    private WebElement repeatPassword;
    @FindBy(name= "pulic-info")
    private WebElement publicInfo;
    @FindBy(id= "sign-in-button")
    private WebElement signInBtn;
    @FindBy(xpath= "//span [contains(text(),' This field is required! ')]")
    private WebElement validationMsg1;
    @FindBy(xpath= "//span [contains(text(),' Passwords do not match! ')]")
    private WebElement validationMsg2;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }
    public void fillUserName(String textToFill) {
        userName.sendKeys(textToFill);
    }
    public void fillEmail(String textToFill) {
        email.sendKeys(textToFill);
    }
    public void fillPassword(String textToFill) {
        password.sendKeys(textToFill);
    }
    public void fillRepeatPassword(String textToFill) {
        repeatPassword.sendKeys(textToFill);
    }
    public void fillDate(String textToFill) {
        date.sendKeys(textToFill);
    }
    public void fillPublicInfo(String textToFill) {
        publicInfo.sendKeys(textToFill);
    }
    public void clickSignInBtn(){
        signInBtn.click();
    }
    public WebElement getUserNameTakenMsg(){
        wait.until(ExpectedConditions.visibilityOf(userNameTakenMsg));
        return userNameTakenMsg;
    }
    public WebElement getSignInBtn(){
        return signInBtn;
    }
    public WebElement getValidationMsg1(){
        return validationMsg1;
    }
    public WebElement getValidationMsg2(){
        return validationMsg2;
    }
}
