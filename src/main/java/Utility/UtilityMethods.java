package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityMethods {
    WebDriver driver;
    public UtilityMethods(WebDriver driver) {
        this.driver=driver;
    }
    //  change made by master dgd



    public void waitforElementToAppear(By element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }





}
