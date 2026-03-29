package AbstractComponents;

import PageObjects.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

public class LaunchApp {

    public WebDriver driver;

    public void launchBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else
            System.out.println("Please enter browser name correctly");
    }

    public LandingPage launchApp(){

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return new LandingPage(driver);

    }

    public void closeBrowser(){
        driver.quit();
    }
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts  = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE) ;
        File file  = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png";
    }


}



