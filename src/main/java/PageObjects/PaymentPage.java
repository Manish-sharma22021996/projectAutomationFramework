package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PaymentPage {

    WebDriver driver;
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'payment__type--cc')]")
    WebElement paymentType;

    @FindBy(xpath = "(//input[@class='input txt'])[1]")
    WebElement enterCCVValue;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement selectCountry;
    @FindBy(css = ".action__submit")
    WebElement orderSubmit;



    public void enterCCV(){
        enterCCVValue.sendKeys("234");
    }
    public void selectYourCountry(String country) throws InterruptedException {
        selectCountry.sendKeys(country);
        Thread.sleep(2000);
        List<WebElement> countries = driver.findElements(
                By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
        for(int index=0;index<countries.size();index++){
            if(countries.get(index).getText().equalsIgnoreCase(country)){
                countries.get(index).click();

            }
        }

    }

    public  SummaryPage placeOrder(){
        orderSubmit.click();
        return new SummaryPage(driver);
    }



}
