package com.buyProcessE2E;

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

    @Test(priority = 0, description = "Launch the application and navigate to login page")
    public void launchApplication() throws InterruptedException {

        launchBrowser("chrome");
        lp = launchApp();

    }

    @Test(priority = 1, description = "Login functionality with valid credentials")
    public void loginFunctionality() {
        home = lp.login();
        System.out.println("logged in successfully");
    }



    @Test(priority = 2, description = "Add product to cart from homepage and validate the product in cart page")
    public void homepagefunctionality() throws InterruptedException {
        cart = home.addProductToCart();

        System.out.println("on Homepage");
    }


    @Test(priority = 3, description = "Validate the product added to cart is correct or not")
    public void assertCartProduct() {
        Assert.assertEquals("ADIDAS ORIGINAL", cart.productConfirmationCartPage());
    }

    @Test(priority = 4, description = "Validate the payment page functionality and place order")
    public void paymentPagefunctionality() throws InterruptedException {
        paymentPage = cart.buyProductBTN();
        paymentPage.enterCCV();
        paymentPage.selectYourCountry("india");
        summaryPage = paymentPage.placeOrder();
    }

    @Test(priority = 5, description = "Validate the order summary page functionality")
    public void summaryPageFunctionality() {

        String summaryHeading = summaryPage.summaryHeadingValidation();
        System.out.println(summaryHeading);
    }

    //cholo firse comment add kare
    @Test(priority = 9, description = "Validate the demo summary page functionality")
    public void demoTestforgetpull() {
        System.out.println("on summary page");
        System.out.println("added for testing git pull");
    }





}
