package AbstractComponents;

import PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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


}
