package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "caption")
    private WebElement caption;
    @FindBy(id = "create-post")
    private WebElement createPost;
    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    public NewPostPage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }
    public void fillCaption(String text){
        caption.sendKeys(text);
    }
    public void clickCreatePost (){
        createPost.click();
    }

}
