package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userEmail")
    WebElement userId;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement btn;

    public void login(){
        userId.sendKeys("testerfisrtlast@gmail.com");
        password.sendKeys("Tester@123");
        btn.click();
        System.out.println("Logged in successfully");
    }



}
