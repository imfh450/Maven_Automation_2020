package Day5_01252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webelemnt_Xpath_mlcalc {
    public static void main (String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOption
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(option);
        //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        //maximize the browser
        //driver.manage().window().maximize();
        //wait few seconds to laod the page
        Thread.sleep(3000);

        //Store purchase price locator as webelement variable to reuse
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear purchase price
        pPrice.clear();
        //enter new value on purchase price
        pPrice.sendKeys("3500000");
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        dPayment.clear();
        dPayment.sendKeys("45");


        //click on calculate button
        driver.findElement(By.xpath("//*[@alt='Calculate']")).click();

        //wait few seconds
        Thread.sleep(2000);

        //capture total monthly payment
        String mntPay = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
        //capture payoff date
        String payoffDate = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();

        //Print out the result
        System.out.println("My monthly pay is "+ mntPay + " and my pay off date is " + payoffDate);


    }//end of main method

}//end of parent class

