package ActionItem;


import Reusable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/*Action Item
Please use Xpath.& Reusable Methods. for FindElements we don't have a reusable method and getText so for those you can just
directly call it driver.find in the script but for click & sendkeys use reusable methods...
Create a Excel sheet with following columns and iterate through 3 times  and send back the result on empty columns
zipCode,  resultAndDistance(this is empty column to write back), operationHour(this is empty column to write back)
Steps:
1. Navigate to https://www.weightwatchers.com/us/
2. Wait about 4 to 5 seconds
3. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
4. On the right corner of the page, click on “Find a Meeting” or “Find a studio” link //you can use class property
5. Wait few seconds about 2 to 3
6. Verify loaded page title matches “Find a Studio & Meeting Near You |”
7. In the search field, search for meetings by zip code
8. Click on Search icon
9. Wait few seconds about 3 to 4
10. Click on the first result link… hint: you can use findElements()
11. Wait few seconds about 3 to 4
12. Print the title of the first result and the distance (located on the right of location title/name) store it back to excel on empty column name resultAndDistance
13. Then click on the result link to go to next page
14. Now from the bottom of the page I want you to capture current day operation hour and store it into a variable and write it back to empty column called operationHour..
If you can not capture current day operation hour then for now just capture the the first operation hour on the list but i would like for you guys to think outside of the box to see how you can capture a current day operation hour by doing some google research, because any day can be a current day...
15. Outside of the loop quit the driver and close readable and writable excel file */
        public class Action_Item4 {
                WebDriver driver;
                Workbook readable;
                Sheet readableSheet;
                int rowCount;
                WritableWorkbook writable;
                WritableSheet wSheet;

                @BeforeMethod
                public void openBrowser() throws IOException, BiffException {

                        //Step1: define the path of your readable excel file
                        readable = Workbook.getWorkbook(new File("src/main/resources/WeightWatchers.xls"));
                        //Step2: define the work sheet for the data
                        readableSheet = readable.getSheet(0);
                        //Step 3: get count of all non empty rows in your excel sheet
                        rowCount = readableSheet.getRows();
                        //Step 4: create a duplicate work book to write back so it doesn't mess up your readable workbook
                        writable = Workbook.createWorkbook(new File("src/main/resources/WeightWatchers_result.xls"),readable);
                        //Step 5: define the writable work sheet to read the data
                        wSheet = writable.getSheet(0);

                        //define the path of chrome driver
                        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                        //set pre arguments using ChromeOptions
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized","incognito");
                        //define the chromedriver
                        driver = new ChromeDriver(options);

                }//Annotation method to define your browser

                 @Test (priority = 1)
                public void testCase() throws IOException, BiffException, InterruptedException, WriteException {

                     for (int i = 1; i < rowCount; i++) {

                             //get the data from item column which is 0
                             String BKzip = wSheet.getCell(0, i).getContents();

                             //navigate to fresh direct
                             driver.navigate().to("https://www.weightwatchers.com/us/");
                             Thread.sleep(3000);
                             //Resuable method to compare expected vs actual title ("Weight Loss Program, Recipes & Help | Weight Watchers")
                             Reusable_Methods.verifyPageTitle(driver, "Weight Loss Program, Recipes & Help | Weight Watchers");
                             //Click On the right corner of the page, click on “Find a Meeting” or “Find a studio” link
                             Reusable_Methods.click(driver, "//*[@class='find-a-meeting']", "Find a Studio");
                             Thread.sleep(4000);
                             //Reusable_Methods.click(driver,"//*[@class='bx-close-xsvg']","Close pop up if exist");
                             try {
                                     Reusable_Methods.click(driver, "//*[@class='bx-close-xsvg']", "close");
                             } catch (Exception err) {
                                     System.out.println("there was no popup" + err);
                             }
                             Thread.sleep(3000);
                             //Verify loaded page title matches “Find a Studio & Meeting Near You |”
                             Reusable_Methods.verifyPageTitle(driver, "Find a Studio & Meeting Near You |");
                             //In the search field, search for meetings by zip code
                             Reusable_Methods.type(driver, "//*[@id='meetingSearch']", BKzip, "Search Field");
                             //Resuable Method to click
                             Reusable_Methods.click(driver, "//*[@class='btn spice-translated']", "Submit");
                             Thread.sleep(4000);

                             //Capture First Search result's location name,address
                       /* String StudioName = Reusable_Methods.captureText(driver,"//*[@ng-if='linkName']","LocationName");
                        String StudioAddress = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__address']",0,"LocationADD1");
                        String StudioAddress2 = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__city-state-zip']",0,"LocationADD2");
                        String StudioDistance = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__distance']",0,"distance");
                        //Store Captured data back into Result XLS file
                        Label labell = new Label(1,i,StudioName + ", "+StudioAddress+", " + StudioAddress2 + ", "+ StudioDistance + ", ");
                        wSheet.addCell(labell);

                      //Select the First search result
                        Reusable_Methods.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",0,"Expand result");
                        Thread.sleep(2500);
                      //Capture Open time for sunday
                       String OperationHour = Reusable_Methods.captureTextByIndex(driver,"//*[Contains(@class,'hours-list--currentday')]",0,"Hours of Operation");
                        //Store Captured data back into XLS
                        Label labell12 = new Label (2,i,"OperationHour");
                        //adding it back to the cell
                        wSheet.addCell(labell12);
                        */

                             //Capturing the stuido information all
                             String StudioInfo = Reusable_Methods.captureTextByIndex(driver, "//*[@class='location']", 0, "Location Name");

                             //Store information back to xls
                             Label label1 = new Label(1, i, StudioInfo);
                             wSheet.addCell(label1);

                             //Select the First search result
                             Reusable_Methods.clickByIndex(driver, "//*[@class='meeting-locations-list__item']", 0, "Expand result");
                             Thread.sleep(2500);

                             //Capture and get operation hours and store in xls
                             String operationHour = Reusable_Methods.captureTextByIndex(driver, "//*[contains(@class,'hours-list--currentday')]", 0, "Op Hour");
                             Label label2 = new Label(2, i, operationHour);
                             wSheet.addCell(label2);


                     }//end of for loop
                }//End of test class


                @AfterMethod
                        public void closeDriver() throws IOException, WriteException {
                             writable.write();
                             writable.close();
                             readable.close();
                             driver.quit();
                }//End of after method

        }//End of java class
//Contain method to contain takes a little portion of an element
//"//*[contains(@href,'womens-clothings')]"
  //[contains(text(),'womens-clothing')]'
