package Day9_02082020;

import Day7_02012020.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.lang.module.ResolutionException;

/*Action Item

Steps:

1. Navigate to https://www.darksky.net

2. Wait about 4 to 5 seconds

3. Verify loaded page title contains “Dark Sky”

4. Enter a valid zip code on search field

5. Click on search icon

6. Capture the current temperature and only extract out the temperature from the following section

7. Capture the message under the temperature and print it out

8. Capture the temperature under ‘Now’ and compare it with the temperature above if it matches

9. Verify that following three hours are separated by 2 hour from current hour by using the date command */

public class Action_Item_ClassWork {
    public static void main(String [] args) throws InterruptedException, IOException, BiffException {

        //Step1: define the path of your readable excel file
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/darksky.xls"));
        //Step2: define the work sheet for the data
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3: get count of all non empty rows in your excel sheet
        int rowCount = readableSheet.getRows();

        //Step 4: create a duplicate work book to write back so it doesn't mess up your readable workbook
        WritableWorkbook writableBook = Workbook.createWorkbook(new File("src/Resource/darksky_Data_Result.xls"),readableFile);
        //Step 5: define the writable work sheet to read the data
        WritableSheet wSheet = writableBook.getSheet(0);


        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);


        for(int i = 1; i < rowCount; i++) {

            //get the data from item column which is 0
            String Bkzip = wSheet.getCell(0, i).getContents();

            //1. Navigate to https://www.darksky.net
            driver.navigate().to("https://www.darksky.net");

            //2. Wait about 4 to 5 seconds
            Thread.sleep(3000);

            //3. Verify loaded page title contains “Dark Sky”
            Reusable_Methods.verifyPageTitle(driver, "Dark Sky");

            //4. Enter a valid zip code on search field
            Reusable_Methods.type(driver, "//*[@type='text']", Bkzip, "Search Field");

            //5. Click on search icon
            Reusable_Methods.click(driver, "//*[@alt='Search Button']", "Search icon");
            Thread.sleep(3000);

            //6. Capture the current temperature and only extract out the temperature from the following section
            String searchresult = Reusable_Methods.captureText(driver, "//*[@class='summary swap']", "Capturing Current Temp");
            String[] searchArray = searchresult.split(" ");

            //7. Capture the message under the temperature and print it out
            String Conditons = Reusable_Methods.captureText(driver, "//*[@class='currently__summary next swap']", "Capturing Current conditions");
            System.out.println(Conditons);

            //8. Capture the temperature under ‘Now’ and compare it with the temperature above if it matches
            String Match = Reusable_Methods.captureText(driver, "//*[@class='first']", "Capturing Now Temperature");
            if (Match == searchresult) {
                System.out.println("Current Temperature Matches 'Now' Temperature");
            } else {
                System.out.println("Current Temperature does not match 'Now' Temperature");
            }


            //9. Verify that following three hours are separated by 2 hour from current hour by using the date command
            String CurrentHour = Reusable_Methods.dateInHour("h", 0);
            String hour2 = Reusable_Methods.dateInHour("h", 2);
            String hour4 = Reusable_Methods.dateInHour("h", 4);
            String hour6 = Reusable_Methods.dateInHour("h", 6);

            //For current hour
            String CurrentHour = "";
            if (driver.findElement(By.xpath("//*@class='" + CurrentHour + "pm']")).isDisplayed()) {
                System.out.println("The time now equals to the current hour");
                //Print if matching
            } else {
                System.out.println("The time now does not equal to the current hour");
                //Print it if not matching
            }

            String Hour2 = "2";
            if (driver.findElement(By.xpath("//*@class='" + Hour2 + "pm']")).isDisplayed()) {
                System.out.println("The time now equals to the current hour");
                //Print if matching
            } else {
                System.out.println("The time now does not equal to the current hour");
                //Print it if not matching
            }

            String Hour4 = "4";
            if (driver.findElement(By.xpath("//*@class='" + Hour4 + "am']")).isDisplayed()) {
                System.out.println("The time now equals to the current hour");
                //Print if matching
            } else {
                System.out.println("The time now does not equal to the current hour");
                //Print it if not matching
            }


            String Hour6 = "6";
            if (driver.findElement(By.xpath("//*@class='" + Hour6 + "am']")).isDisplayed()) {
                System.out.println("The time now equals to the current hour");
                //Print if matching
            } else {
                System.out.println("The time now does not equal to the current hour");
                //Print it if not matching
            }
        }//end of loop





            driver.quit();

        }//End of parent class
    }//End of main class

