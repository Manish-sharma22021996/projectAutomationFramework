package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = ".mb-3")
    List<WebElement> products;





    public CartSectionPage addProductToCart() throws InterruptedException {
            WebElement prod  =products.stream().filter(product ->
                    product.findElement(By.cssSelector("b")).
                    getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);

            prod.findElement(By.cssSelector(".card-body button:first-of-type")).click();



        addToCartBtn.click();
        Thread.sleep(3000);
        cart.click();
        Thread.sleep(3000);

        return new CartSectionPage(driver);

    }



}
