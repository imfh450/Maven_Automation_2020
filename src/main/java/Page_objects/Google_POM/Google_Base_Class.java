package Page_objects.Google_POM;

import Reusable_library.Abstract_Class_Regular;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Google_Base_Class extends Abstract_Class_Regular {
    public Google_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;

    }//end of page object constructor

    ////Object for google home page
    public static Homepage homepage (){
        Homepage homepage = new Homepage(driver);
        return homepage;
    }

    ///Object for search result page
    public static SearchResultpage searchResultpage (){
        SearchResultpage searchResultpage = new SearchResultpage(driver);
        return searchResultpage;
    }
}//End of main method
