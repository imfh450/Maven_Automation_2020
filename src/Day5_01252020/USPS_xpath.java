package Day5_01252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class USPS_xpath {

    public static void main (String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOption
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(option);
        //navigate to usps.com
        driver.navigate().to("https://www.usps.com");
        //maximize the browser
        //driver.manage().window().maximize();
        //wait few seconds to laod the page
        Thread.sleep(3000);
       //using xpath text property to click on Quick Tools tab
        driver.findElement(By.xpath("//*[text()='Quick Tools' and @class='nav-first-element menuitem']")).click();





    }//end of main method

}//end of parent class
