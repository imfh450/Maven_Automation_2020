package Day4_01192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {


    public static void main (String[] args) throws InterruptedException {

        String [] cars = new String[4];
        cars[0] = "BMW ";
        cars[1] = "Mercedes ";
        cars[2] = "Lexus ";
        cars[3] = "Nissan ";

        //define the path of where the chrome driver is stored
        System.setProperty("webdriver.chrome.driver","src\\Resource\\chromedriver.exe");
        //defining the actual web driver (chrome driver)
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i< cars.length;i++) {
            //Navigate to google.com
            driver.get("https://www.google.com");

            //Maxmize my driver
            driver.manage().window().maximize();

            //sleep statement
            Thread.sleep(1000);

            //Enter brooklyn in your search field
            driver.findElement(By.name("q")).sendKeys(cars[i]);
            //Click on google search
            driver.findElement(By.name("btnK")).submit();
            //Wait few second
            Thread.sleep(3000);
            //Capture the text into a string variable
            String message = driver.findElement(By.id("resultStats")).getText();
            String[] arraymessage = message.split(" ");
            //print out search number
            System.out.println("My search number for " + cars[i]+"is " + arraymessage[0]);
        }//End of for loop
        //quit my driver
        driver.quit();




    }//end of main class



}//end of parent class




