import AbstractComponents.LaunchApp;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends LaunchApp {
    private LandingPage lp;
    private CartSectionPage cart ;
    private HomePage home;
    private SummaryPage summaryPage;
    private PaymentPage paymentPage;

    @Test(priority = 0)
    public void launchApplication() throws InterruptedException {

        launchBrowser("chrome");
        lp = launchApp();

    }

    @Test(priority = 1)
    public void loginFunctionality() {
        home = lp.login();
        System.out.println("logged in successfully");
    }



    @Test(priority = 2)
    public void homepagefunctionality() throws InterruptedException {
        cart = home.addProductToCart();

        System.out.println("on Homepage");
    }


    @Test(priority = 3)
    public void assertCartProduct() {
        Assert.assertEquals("ADIDAS ORIGINAL", cart.productConfirmationCartPage());
    }

    @Test(priority = 4)
    public void paymentPagefunctionality() throws InterruptedException {
        paymentPage = cart.buyProductBTN();
        paymentPage.enterCCV();
        paymentPage.selectYourCountry("india");
        summaryPage = paymentPage.placeOrder();
    }

    @Test(priority = 5)
    public void summaryPageFunctionality() {

        String summaryHeading = summaryPage.summaryHeadingValidation();
        System.out.println(summaryHeading);
    }





}
