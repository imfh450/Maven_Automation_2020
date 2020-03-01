package Day8_02022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseActions {

    public static void main(String [] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOption
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(option);

        //navigate to usps
        driver.navigate().to("https://www.usps.com");
        //wait few seconds
        Thread.sleep(3000);

        //using mouse actions to hover over an element
        Actions mouseAction = new Actions(driver);
        //move to Quick tools element
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        //moving to quick tools
        mouseAction.moveToElement(quickTools).perform();
        Thread.sleep(1500);
        //Store track a package as a webelement variable
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        //click on track a package using mouse movement
        mouseAction.moveToElement(trackPackage).click().perform();

        Thread.sleep(4000);
        //enter a keyword on tracking field
        WebElement trackField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseAction.moveToElement(trackField).click().sendKeys("11111111111111111111").perform();
        //Click on the track button using text
        WebElement track = driver.findElement(By.xpath("//*[text()='Track']"));
        mouseAction.moveToElement(track).click().perform();
        //Also use build if .perform does not work work
        //mouseAction.moveToElement(trackPackage).click().build().perform();
        //Using Mouse send keys


    }//End of main method

}//End of parent class

