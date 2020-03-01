package ActionItem;

import Reusable_library.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.RuntimeBehavior;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Yahoo_Signin_Boolean {
    WebDriver driver;

    @BeforeMethod
    public void OpenBRowser() throws IOException {
        //Quit all chrome driver which are open
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");
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
    public void usps() throws InterruptedException {
        driver.navigate().to("https://yahoo.com/");

        //Click on yahoo sign in
        Reusable_Methods.click(driver,"//*[text()='Sign in']","Sign in");

        //Verify that stay signed in checkbox is selected
        Thread.sleep(3000);
        Boolean checkbox = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkbox==true) {
            System.out.println("Stay Signed in checkbox is selected");
        }else{
            System.out.println("Stay signed in check box is not selcted");
        }

        Thread.sleep(3000);
        Boolean checkboxDis = driver.findElement(By.xpath("//*[@id='persistent']")).isDisplayed();
        if (checkboxDis==true) {
            System.out.println("Stay Signed in checkbox is Displayed ");
        }else{
            System.out.println("Stay signed in check box is not Displayed");
        }

        //Verify if create account button is there then click on it
        Boolean createACC = driver.findElement(By.xpath("//*[@id='createacc']")).isEnabled();
        if (createACC=true) {
            driver.findElement(By.xpath("//*[@id='createacc']")).click();
            System.out.println("Create Account was enable ");
        }else{
            System.out.println("Create account is not enabled");
        }//end of if else for checkbox


    }//End of test method
    @AfterMethod
    public void closeBrowser(){
        //driver.quit();
    }
}//End of java class
