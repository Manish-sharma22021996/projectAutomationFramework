import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
   public void  main() throws InterruptedException {
       WebDriver driver=  new ChromeDriver();
       LandingPage lp = new LandingPage(driver);
       HomePage home = new HomePage(driver);
        CartSectionPage cart = new CartSectionPage(driver);


       driver.get("https://rahulshettyacademy.com/client/#/auth/login");
       lp.login();
       System.out.println("browser opened");
       Thread.sleep(3000);
       home.productName();
        Thread.sleep(3000);
       home.addProductToCart();
       System.out.println("product added to cart");
        Assert.assertEquals("ZARA COAT 3", cart.productConfirmationCartPage());
        PaymentPage paymentPage= cart.buyProductBTN();
        paymentPage.enterCCV();
        paymentPage.selectYourCountry("india");
        SummaryPage summaryPage = paymentPage.placeOrder();
        String summaryHeading = summaryPage.summaryHeadingValidation();
        System.out.println(summaryHeading);
//        Thread.sleep(3000);
//        Assert.assertEquals( "Thankyou for the order.", summaryHeading);




   }


}
