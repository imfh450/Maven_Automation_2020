package ActionItem;

import Reusable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
/*Action Item
Use reusable methods for all test steps and create following columns on your excel sheet.
size,quantity,firstName,lastName,email,phoneNumber,address,zipCode,city,state,cardNumber, errorMessage(empty column)
Iterate three times at least with using testNG annotations(BeforeMethod,Test,AfterMethod) concept only.

//since we are looping  so just use only one @Test  annotation method
Step 1. Navigate to http://www.express.com
Step 2. Verify we are on following page title contains ‘Men’s and Women’s Clothing’
Step 3: Hover on ‘Women’ tab using Actions //use contains @href property
Step 4: click on  ‘Dresses’ link //use contains @href property or you can use text() property
Step 5: wait few seconds using Thread.sleep and Scroll about 400 to 500 pixels
Step 6. Click on second image //use @class property with index number  as 1. you can use clickByIndex() method from your reusable
Step 7: wait few seconds on next page
Step 8 On size page click on specific size(choose different size each time on excel) and the value should be passed in xpath locator as text() or @value property
Step 9: Click on ‘Add to Bag’ button
Step 10: on pop up to the right side click on ‘View Bag’ tab  then wait few seconds
Step 11: Select a quantity(choose different one each time) //you can use dropdown reusable method by visible text which i created for you in reusable method class
Step 12: Click on  ‘Checkout’ button then wait few seconds
Step 13: on pop up click on ‘Continue as Guest’ button then wait few seconds
Step 14: Enter first name
Step 15:  Enter last name
Step 16: Enter Email address(put invalid address)
Step 17: Re-enter Email address(put same email above)
Step 18: enter phone number(invalid numeric 10 digit number)
Step 19: Click on ‘Continue’ button
Step 20: Click on ‘Continue’ button again
Step 21: Enter address(invalid one. For instance, 111, 222, etc…)
Step 22: Enter zip code(different boroughs zipcode)
Step 23: Enter city(different boroughs)
Step 24: Select state(keep as NY for zip codes)
Step 25: click on continue button
Step 26: Clear and Enter card number(use invalid card number for different card type. Look into examples of American express, discover, master & visa)
Step 27. Click on ‘Place Order’ button type="submit"
Step 28: capture the error message for card number field and send it back to  errorMessage column in excel
Step 29. type on your @Test method inside loop at the end ‘driver.manage().DeleteAllCookies(); so your address info and cart items doesn’t get stored once you navigate again to the site and checkout. It will delete the cache */


public class Action_Item_Maven_Express {
    WebDriver driver;
    Workbook readable;
    Sheet readableSheet;
    int rowCount;
    WritableWorkbook writable;
    WritableSheet wSheet;

    @BeforeMethod
    public void Express() throws IOException, BiffException {

        //Step 1.  Define the path of the readable excel file
        readable = Workbook.getWorkbook(new File("src/main/resources/Express_DataSheet.xls"));
        //Step 2.  Define the worksheet for data
        readableSheet = readable.getSheet(0);
        //Step 3.  Get count of all non empty rows in your excel sheet
        rowCount = readableSheet.getRows();
        //Step 4.  Create duplicate workbook to write back on so it does not write on orginal data sheet
        writable = Workbook.createWorkbook(new File("src/main/resources/Express_DataSheet_Result.xls"), readable);
        //Step 5.  Define the writeable worksheet to read the data
        wSheet = writable.getSheet(0);


        //Step 6. define the path of chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Step 7. set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        //Step 8. define the chromedriver
        driver = new ChromeDriver(options);

    }//Method to end  to define the browser

    @Test(priority = 0)

    public void Expresstestcase1() throws InterruptedException, WriteException, IOException {
        for (int i = 1; i < rowCount; i++) {
            //Step 1.  Navigate to http://www.express.com
            driver.navigate().to("http://www.express.com");
            Thread.sleep(2000);
            //Step 2. Verify we are on following page title contains ‘Men’s and Women’s Clothing’
            Reusable_Methods.verifyPageTitle(driver, "Men’s and Women’s Clothing");
            //Step 3: Hover on ‘Women’ tab using Actions //use contains @href property
            //Contain method to contain takes a little portion of an element
            //"//*[contains(@href,'womens-clothings')]" //[contains(text(),'womens-clothing')]'
            //Reusable_Methods.mouseHover(driver, "//*[contains(@href,'/womens-clothing']", "WomenTab");
            Reusable_Methods.mouseHover(driver, "//*[@href='/womens-clothing']", "WomenTab");
            //Step 4: click on  ‘Dresses’ link //use contains @href property or you can use text() property
            //Reusable_Methods.clickByMouse(driver, "//*[@href='/womens-clothing/dresses/cat550007']", "ClickDress");
            Reusable_Methods.clickByMouse(driver, "//*[contains(@href,'/womens-clothing/dresses/')]", "ClickDress");
            //Step 5: wait few seconds using Thread.sleep and Scroll about 400 to 500 pixels
            Thread.sleep(2000);
            JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
            scrollDown.executeScript("scroll(0,500)");
            //Step 6. Click on second image //use @class property with index number  as 1. you can use clickByIndex() method from your reusable
            Reusable_Methods.clickByIndex(driver, "//*[@class='active loaded']", 1, "SecondDress");
            //Step 7: wait few seconds on next page
            Thread.sleep(1000);
            //Step 8 On size page click on specific size(choose different size each time on excel) and the value should be passed in xpath locator as text() or @value property
            //Get the data from column which is 0
            String DressSize = wSheet.getCell(0, i).getContents();
            Reusable_Methods.click(driver, "//*[text()='" + DressSize + "']", "Dress size");
            //Step 9: Click on ‘Add to Bag’ button
            Thread.sleep(1000);
            Reusable_Methods.click(driver, "//*[text()='Add to Bag']", "Add to Bag");
            //Step 10: on pop up to the right side click on ‘View Bag’ tab  then wait few seconds
            Thread.sleep(1000);
            Reusable_Methods.click(driver, "//*[text()='View Bag']", "View Bag Pop Up");
            //Step 11: Select a quantity(choose different one each time) //you can use dropdown reusable method by visible text which i created for you in reusable method class
            Thread.sleep(1000);
            Reusable_Methods.click(driver, "//*[@id='qdd-0-quantity']", "Selecting Quantity Field");
            //Create String for Quantity so you can call for it from the excel
            String Quantity = wSheet.getCell(1, i).getContents();
            //Reusable_Methods.click(driver, "//*[text()='" + Quantity + "']", "Quantity Ordering");
            Reusable_Methods.dropDownSelect(driver, "//*[@id='qdd-0-quantity']",Quantity, "Quantity Ordering");
            //Step 12: Click on  ‘Checkout’ button then wait few seconds
            Thread.sleep(2000);
            Reusable_Methods.click(driver, "//*[@id='continue-to-checkout']", "Checkout");
            Thread.sleep(2000);
            //Step 13: on pop up click on ‘Continue as Guest’ button then wait few seconds
            Reusable_Methods.click(driver, "//*[text()='Continue as Guest']", "Continue as Guest");
            Thread.sleep(1000);
            //Step 14: Enter first name
            String FirstName = wSheet.getCell(2, i).getContents();
            Reusable_Methods.type(driver, "//*[@id='contact-information-firstname']", FirstName, "FirstName");
            Thread.sleep(1000);
            //Reusable_Methods.type(driver,"//*[text()='"+firstname+"']","First Name");
            //Step 15:  Enter last name
            String LastName = wSheet.getCell(3, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='lastname']", LastName, "LastName");
            Thread.sleep(100);
            //Step 16: Enter Email address(put invalid address)
            String Email = wSheet.getCell(4, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='email']", Email, "Email");
            Thread.sleep(100);
            //Step 17: Re-enter Email address(put same email above)
            String EmailRe = wSheet.getCell(4, i).getContents();
            Reusable_Methods.type(driver, "//*[@class='ff8oN inputInactive _3Lgrd']", EmailRe, "ConfirmEmail");
            //Step 18: enter phone number(invalid numeric 10 digit number)
            String PhoneNum = wSheet.getCell(5, i).getContents();
            Reusable_Methods.type(driver, "//*[@type='tel']", PhoneNum, "Phone Number");
            Thread.sleep(1000);
            //Step 19: Click on ‘Continue’ button
            Reusable_Methods.click(driver, "//*[text()='Continue']", "ContinueButton");
            Thread.sleep(1000);
            //Step 20: Click on ‘Continue’ button again
            Reusable_Methods.click(driver, "//*[text()='Continue']", "ContinueButtonX2");
            Thread.sleep(100);
            //Step 21: Enter address(invalid one. For instance, 111, 222, etc…)
            String ShippingADD = wSheet.getCell(6, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='shipping.line1']", ShippingADD, "ShippingAddress");
            Thread.sleep(100);
            //Step 22: Enter zip code(different boroughs zipcode)
            String ZipCode = wSheet.getCell(7, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='shipping.postalCode']", ZipCode, "ZipCode");
            Thread.sleep(100);
            //Step 23: Enter city(different boroughs)
            String City = wSheet.getCell(8, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='shipping.city']", City, "City");
            Thread.sleep(1000);
            //Step 24: Select state(keep as NY for zip codes)
            String State = wSheet.getCell(9, i).getContents();
            Reusable_Methods.click(driver, "//*[text()='" + State + "']", "State");
            Thread.sleep(300);
            //Step 25: click on continue button
            Reusable_Methods.click(driver, "//*[text()='Continue']", "Continue button");
            Thread.sleep(1000);
            //Step 26: Clear and Enter card number(use invalid card number for different card type. Look into examples of American express, discover, master & visa)
            String CCNum = wSheet.getCell(10, i).getContents();
            Reusable_Methods.type(driver, "//*[@name='creditCardNumber']", CCNum, "CCNum");
            Thread.sleep(100);
            //Step 27: Enter CC Month
            String CCMonth = wSheet.getCell(11, i).getContents();
            Reusable_Methods.click(driver, "//*[@name='expMonth']", "CCMonth");
            Reusable_Methods.dropDownSelect(driver, "//*[@name='expMonth']", CCMonth, "CCMonth");
            Thread.sleep(1000);
            //Step 28:  Enter CC Year
            String CCYear = wSheet.getCell(12, i).getContents();
            Reusable_Methods.click(driver, "//*[@name='expYear']", "CC Year");
            Reusable_Methods.dropDownSelect(driver, "//*[@name='expYear']", CCYear, "CCYear");
            Thread.sleep(1000);
            //Step 29.  Enter CCV code
            String CCV = wSheet.getCell(13, i).getContents();
            Reusable_Methods.click(driver, "//*[@name='cvv']", "Selecting CCV");
            Reusable_Methods.type(driver, "//*[@name='cvv']", CCV, "CCV Code");
            Thread.sleep(1000);
            //Step 30. Click on ‘Place Order’ button (type="submit")
            Reusable_Methods.click(driver, "//*[@type='submit']", "Place Order");
            Thread.sleep(1000);
            //Step 31: capture the error message for card number field and send it back to  errorMessage column in excel
            String ErrorMessage = Reusable_Methods.captureText(driver,"//*[@id='rvn-note-NaN']","Capture Error Message");
            Label ErrorMSG = new Label(14, i, (ErrorMessage));
            wSheet.addCell(ErrorMSG);
            Thread.sleep(100);

            driver.manage().deleteAllCookies();
        }
    }

    @AfterMethod
    public void closeDriver() throws IOException, WriteException {
        writable.write();
        writable.close();
        readable.close();
        driver.quit();
    }//End of after method
}