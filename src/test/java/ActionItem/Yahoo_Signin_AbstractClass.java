package ActionItem;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods;
import Reusable_library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Yahoo_Signin_AbstractClass extends Abstract_Class {

    @Test
    public void Yahoo_Signin() throws InterruptedException, IOException {
        driver.navigate().to("https://yahoo.com/");

        //click on yahoo sign in
        Reusable_Methods_Reports.click(driver,"//*[text()='Sign in']",logger,"Sign in");

       //verify that stay signed in checkbox is selected
        Thread.sleep(4000);
        Boolean checkbox = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if(checkbox == true){
            System.out.println("Stay Signed in checkbox is selected");
            logger.log(LogStatus.PASS,"Stay Signed in checkbox is selected");
        } else {
            System.out.println("Stay Signed in checkbox is not selected");
            logger.log(LogStatus.FAIL,"Stay Signed in checkbox is not selected");
        }//end of if else for checkbox

        //verify if create account button is there then click on it
        Reusable_Methods_Reports.click(driver,"//*[text()='Create an account']",logger,"Create an accont");
    }

}//end of test method

