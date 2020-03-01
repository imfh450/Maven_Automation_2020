package Day4_01192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_Item_4 {
    public static void main (String[] args) throws InterruptedException {

        String [] countries = new String[5];
        countries[0] = "Canada";
        countries[1] = "America";
        countries[2] = "China";
        countries[3] = "India";
        countries[4] = "Germany";

        //Define the path where the chrome driver is stored
        System.setProperty("webdriver.chrome.driver","src\\Resource\\chromedriver.exe");
        //Define the actual webdriver (chrome driver)
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i< countries.length;i++) {
            //Navigate to bing.com
            driver.get("https://www.bing.com");

            //Maxmize my driver
            driver.manage().window().maximize();

            //Sleep statement wait a few sec
            Thread.sleep(1000);

            //Enter Countries in the search field
            driver.findElement(By.name("q")).sendKeys(countries[i]);
            //Click on bing search
            driver.findElement(By.id("sb_form_go")).submit();
            //wait a few sec
            Thread.sleep(5000);

            //Capture the text into a sting variable
            String message = driver.findElement(By.className("sb_count")).getText();
            String[] arraymessage = message.split(" ");

            //print out search number
            System.out.println("My search result for " + countries[i] + " is " + arraymessage[0]);

        }//End of for loop
            //Quit my driver
            driver.quit();



    }//End of main class

}//End of parent class
