package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
   public WebDriver driver;

   public HomePage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver, this);
   }

   @FindBy(xpath = "//b[text()='ZARA COAT 3']")
    WebElement coat;

   @FindBy(xpath = "(//div[@class='card-body']//button[contains(text(), 'View')])[1]")
    WebElement viewBtn;

    @FindBy(xpath = "//div[@class='product-buttons']/button[@class='btn btn-primary']")
    WebElement addToCartBtn;

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cart;

    public void productName(){
        System.out.println(coat.getText());
    }

    public void addProductToCart(){
        viewBtn.click();
        addToCartBtn.click();
        cart.click();

    }



}
