package Day6_01262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mortgagecalc_gettitle_select {

    public static void main(String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOption
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(option);

        //navigate to mlcalc.com
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //Verify the page title is Mortage Calculator
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Mortgage Calculator")) {

            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match - " + actualTitle);
        }

        //Select February from start month dropdown
        //First store the locator as WebElement Variable
        WebElement startMonth = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
               //Call the select command
               // Select smDropdown = new Select(startMonth);
                //SElect value by visibleText
                //smDropdown.selectByVisibleText("Feb");

        //click on start month drop down
        startMonth.click();
        //click on the value
        driver.findElement(By.xpath("//*[text()='Feb']")).click();


    }//End of main Class


}//End of parent class
