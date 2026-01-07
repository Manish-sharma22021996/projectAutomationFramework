package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import javax.xml.xpath.XPath;

public class CartSectionPage {
    public WebDriver driver;
    public CartSectionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    WebElement productTextOnCartPage;

    @FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(),'Buy Now')]")
    WebElement buyNowBtn;

    public String productConfirmationCartPage(){
        System.out.println(productTextOnCartPage.getText());
        return productTextOnCartPage.getText();
    }

    public PaymentPage buyProductBTN(){
        buyNowBtn.click();
        return new PaymentPage(driver);
    }
}
