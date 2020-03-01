package ActionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium_02162020 {
    WebDriver driver;

    @BeforeMethod
    public void OpenBRowser(){

        //Step 6. define the path of chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Step 7. set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        //Step 8. define the chromedriver
        driver = new ChromeDriver(options);

        //Inititate the implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }//End of before method

    @Test
    public void usps(){
        driver.navigate().to("https://usps.com/");

        //Declare and define WEbdriverWait for explict wait
        WebDriverWait wait = new WebDriverWait(driver,7);

        //List<WebElement>linkCount= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[(contains,'lang- ')]")));
        //Store your find elements using list command to get the group count
        List<WebElement>linkCount= driver.findElements(By.xpath("//*[contains(@class,'lang-')]"));

        //Print out the size to get the count
        System.out.println("My Link count is " + linkCount.size());

    }//End of test method
    @AfterMethod
    public void closeBrowser(){
        //driver.quit();
    }
}//End of java class
