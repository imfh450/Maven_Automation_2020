package Cucumber.StepDefinitions;

import Reusable_library.Reusable_Methods;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class GoogleTestCases {
    //Declare webdriver outside since it will be used on all methods
    WebDriver driver;

    @Given("^I navigated to Google home page$")
    public void navigate () throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");
        Thread.sleep(3000);
        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");

    }
    @When("^I verify the expected title as Google$")
    public void verifyTitle (){
        Reusable_Methods.verifyPageTitle(driver,"Google");

    }//end of when

    @When("^I type cars (.*) in google search field$")
            public void typeOnSearch(String Cars){
        Reusable_Methods.type(driver,"//*[@name='q']",Cars,"Search cars");
    }//end of when

    @And("^I submit or click on google search$")
    public void clickOnSearch(){
        Reusable_Methods.submit(driver,"//*[@name='q']","Search Field");
    }//End of And

    @Then("^I capture and extract the search numbers$")
    public void getSearchNumber(){
        String message = Reusable_Methods.captureText(driver,"//*[@id='result-stats' or @id='mBMHK']","Capturing Result");
        String[] ArrayMSG=message.split(" ");
        Reporter.addStepLog("My search number for car is "+ ArrayMSG [1]);
        System.out.println("My search number for car is " + ArrayMSG[1]);

    }//End of then



}
