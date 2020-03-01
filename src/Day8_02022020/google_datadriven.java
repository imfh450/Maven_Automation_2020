package Day8_02022020;

import Day7_02012020.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

/*public class google_datadriven {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException {
        //Step1: define the path of your readable excel file
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/FreshDirect_Data.xls"));
        //Step 2: Define the work sheetfor the data (xl file sheet where data is stored)
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3: get count of all non empty rows in your excel sheet
        int rowCount = readableSheet.getRows();
        //Step 4:  Create a duplicate work book to write back so it doesn't mess up your readable workbook
        WritableWorkbook writableBook = Workbook.createWorkbook(new File("src/Resource/FreshDirect_Data_Result.xls"),readableFile);
        //Step 5:define the writable work sheet to read the data
        WritableSheet wSheet= writableBook.getSheet(0);

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOption
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(option);

        for(int i = 1; i <rowCount; i++){
            //Get the data from item column which is 0
            String itemName= wSheet.getCell(0,i).getContents();
            //get the data from Department column which is 1.
            String departName = wSheet.getCell(1,i).getContents();
            //Get the data from Brand column which is 2
            String brandName = wSheet.getCell(2,i).getContents();

            //navigate to fresh direct
            driver.navigate().to("https://www.freshdirect.com");
            Thread.sleep(3000);
            //reusable method to enter keyboard in search field
            Reusable_Methods.type(driver, "//*[@id='topSearchField']",itemName,"Search Field");
            //reusable method to click on search icon
            Reusable_Methods.click(driver,"//*[@id='topInputFindButton_fdx']","Search Button");
            //Put few seconds to wait for page to load
            Thread.sleep(4000);
            //Click on department type by passing the variable on Xpath
            Reusable_Methods.click(driver,"//*[text()='Select a brand]","Select a Brand");
            //Wait few seconds
            Thread.sleep(1500);
            //click on Brand Type
            Reusable_Methods.click(driver,"//*[text()='"+brandName+"']","Brand Type");

        }//end of for loop



    }//end of parent class
}//end of main class*/




public class google_datadriven {


    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {


        //Step1: define the path of your readable excel file
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/GoogleSearch.xls"));
        //Step2: define the work sheet for the data
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3: get count of all non empty rows in your excel sheet
        int rowCount = readableSheet.getRows();

        //Step 4: create a duplicate work book to write back so it doesn't mess up your readable workbook
        WritableWorkbook writableBook = Workbook.createWorkbook(new File("src/Resource/GoogleSearch_Result.xls"),readableFile);
        //Step 5: define the writable work sheet to read the data
        WritableSheet wSheet = writableBook.getSheet(0);

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);

        for(int i = 1; i < rowCount; i++){

            //get the data from item column which is 0
            String categoryname = wSheet.getCell(0,i).getContents();

            //navigate to fresh direct
            driver.navigate().to("https://www.google.com");
            Thread.sleep(3000);
            //reusable method to enter keyword in search field
            Reusable_Methods.type(driver,"//*[@name='q']",categoryname,"Search Field");
            Thread.sleep(1500);
            //reusable method to click on search icon
            driver.findElement(By.xpath("//*[@name='btnK']")).click();
            //put few seconds to wait for page to load
            Thread.sleep(4000);
            //store the search result to string variable
            String searchresult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
            String[] searchArray = searchresult.split(" ");
            //writing the result number back to writable excel
            Label value = new Label(1,i,searchArray[1]);
            //adding it back to the cell
            wSheet.addCell(value);
        }//end of for loop
        writableBook.write();
        writableBook.close();
        readableFile.close();

        driver.quit();



    }//end of main method


}//end of parent class



