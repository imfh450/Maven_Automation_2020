package Google_POM_Testcases;

import Page_objects.Google_POM.Google_Base_Class;
import Reusable_library.Abstract_Class_Regular;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_GoogleSearchNumber extends Abstract_Class_Regular {

    @Test
    public void googleSearchResult() throws IOException, InterruptedException {
        driver.navigate().to("https://www.google.com");
        Google_Base_Class.homepage().userSearch("Cars");
        Google_Base_Class.homepage().submitOnSearchField();
        Google_Base_Class.searchResultpage().captureSearchNumber();
    }
}
