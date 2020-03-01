package Page_objects.Google_POM;

import Reusable_library.Abstract_Class_Regular;
import Reusable_library.Reusable_Methods;
import Reusable_library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SearchResultpage extends Abstract_Class_Regular {
    //declare you logger locally when you use page object
    ExtentTest logger;
    //Constructor method is when a child/sub-class having identical
    //name as parent class
    public SearchResultpage(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;

    }//end of page object constructor

    String resultLock = "//*[@id='result-stats']";

    //capturing and printing out the number to the report
    public SearchResultpage captureSearchNumber() throws IOException, InterruptedException {
       String searchResult= Reusable_Methods_Reports.captureText(driver,resultLock,logger,"Capturing Text");
       String [] arraySearch = searchResult.split(" ");
       logger.log(LogStatus.INFO,"Search number is"+arraySearch);
       return new SearchResultpage(driver);
    }

}
