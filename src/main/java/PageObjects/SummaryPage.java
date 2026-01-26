package PageObjects;

import Utility.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage extends UtilityMethods {
    WebDriver driver;

    SummaryPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hero-primary")
    WebElement summaryPageHeading;

    By ele  = By.cssSelector(".hero-primary");

    public String summaryHeadingValidation(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
        waitforElementToAppear(ele);
        return summaryPageHeading.getText();
    }
}
