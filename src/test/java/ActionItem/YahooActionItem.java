package ActionItem;

import Reusable_library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class YahooActionItem {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void OpenYahooBrowser(){
    //define the path where you want to save the Extent Report
        reports = new ExtentReports("src\\main\\java\\Extent_Reports\\YahooActionItem.html",true);
        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }//End of before method

    @Test
    public void Yahooattest() throws IOException, InterruptedException {
        //define the logger for the report
        logger = reports.startTest("Yahoo Search");
        //Step 1. Navigate to https://www.yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //Step 2. Assert that we are on the correct page by checking the title = 'Yahoo‘
        Reusable_Methods_Reports.verifyPageTitle(driver,logger,"Yahoo");
        //Step 3. Display the count of options on the left side panel ('Mail', 'News', 'Sports‘ & ‘More Yahoo Sites’)
        // use contains with class property which has value mstart …
        List<WebElement>linkCount= driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px)')]"));
        //Print out the size to get the count
        System.out.println("My Link count is " + linkCount.size());
        logger.log(LogStatus.INFO,"My Link count is " + linkCount.size());
        //Step 4: Enter 'Nutrition' on the search bar on the top
        Reusable_Methods_Reports.type(driver,"//*[@id='header-search-input']",logger,"Nutrition","Search Field");
        //Step 5: Click on ‘Search’ button
        Reusable_Methods_Reports.click(driver,"//*[@id='header-desktop-search-button']",logger,"Click Search");
        //Step 6. Scroll down to the page
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("scroll(0,10000)");
        Thread.sleep(1500);
        //Step 7: Capture the search result Number by splitting from the getText
        String splitresult = Reusable_Methods_Reports.captureText(driver,"//*[@class='compPagination']",logger,"Splitting Result");
        String[] ArrayMessage = splitresult.split("Next");
        logger.log(LogStatus.INFO,"My search number is "+ArrayMessage[1]);
        reports.endTest(logger);
        //Step 8: Scroll up and click on Image link
        JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
        scrollUp.executeScript("scroll(1000,0)");

    }//End of test method




    @AfterSuite
    public void closeSession(){
        reports.flush();
        driver.quit();

    }//end of after method
}//End of java class

