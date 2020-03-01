package Day7_02012020;

/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;

public class TestMetLife_loops_Scrolling {

    public static void main(String[] args) throws InterruptedException, IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver.exe");

        //quit all open chrome browsers
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");

        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-maximized", "incognito");

        //define the chrome web driver
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> postalCode = new ArrayList<>();
        postalCode.add("11218");
        postalCode.add("11219");
        postalCode.add("10001");

        ArrayList<String> ppoType = new ArrayList<>();
        ppoType.add("PPO-LOW");
        ppoType.add("PPO-MEDIUM");
        ppoType.add("PPO-HIGH");

        ArrayList<String> referallCode = new ArrayList<>();
        referallCode.add("111111");
        referallCode.add("2222222");
        referallCode.add("3333aaadfdfdfd");


        for (int i = 0; i < 3; i++) {
            //navigate to Metlife
            driver.navigate().to("https://www.metlife.com/");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
            Thread.sleep(1500);
            //click on Metline Dental tab
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            Thread.sleep(3500);
            //click on Enroll Now button
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            //define window handle for tabs
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            //enter zip code
            System.out.println("Now Entering Zip/Postal Code " + postalCode.get(i));
            WebElement zip = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
            zip.clear();
            zip.sendKeys(postalCode.get(i));
            //click on Go button
            driver.findElement(By.xpath("//*[text()='GO']")).click();
            Thread.sleep(5500);

            //define javascriptexecutor to scroll on a page
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //Scrolling down to PPO type
            jse.executeScript("scroll(0,700)");
                Thread.sleep(1000);


                //click on PPO-LOW
            driver.findElement(By.xpath("//*[@class='" + ppoType.get(i) + "']")).click();
            //click on Enroll In Program Now button
            driver.findElement(By.xpath("//*[contains(text(),'ENROLL IN PROGRAM NOW')]")).click();
            Thread.sleep(4000);
            //enter invalid referall code
            driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referallCode.get(i));
            //click on Go
            driver.findElement(By.xpath("//*[text()='GO']")).click();
            Thread.sleep(3000);
            //capture error message and verify it matches with your expected text
            String errMessage = driver.findElement(By.xpath("//*[contains(@id,'lblRefCodeError')]")).getText();
            if(errMessage.equals("Referral Code was not recognized")){
                System.out.println("Referall code error message matches");
            } else {
                System.out.println("Referall code error doesn't match " + errMessage);
            }
            //click on Enroll witout a code
            driver.findElement(By.xpath("//*[text()='Enroll without a Referral Code']")).click();
            Thread.sleep(2000);
            //close your current tab which is second tab
            driver.close();
            //switch to first default tab
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(1500);
        }//end of loop


    }//end of main method

}//end of class */


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;

public class TestMetLife_loops_Scrolling {

    public static void main(String[] args) throws InterruptedException, IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver.exe");

        //quit all open chrome browsers
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");

        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-maximized", "incognito");

        //define the chrome web driver
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> postalCode = new ArrayList<>();
        postalCode.add("11218");
        postalCode.add("11219");
        postalCode.add("10001");

        ArrayList<String> ppoType = new ArrayList<>();
        ppoType.add("PPO-LOW");
        ppoType.add("PPO-MEDIUM");
        ppoType.add("PPO-HIGH");

        ArrayList<String> referallCode = new ArrayList<>();
        referallCode.add("111111");
        referallCode.add("2222222");
        referallCode.add("3333aaadfdfdfd");


        //define javascriptexecutor to scroll on a page
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 3; i++) {
            //navigate to Metlife
            driver.navigate().to("https://www.metlife.com/");
            Thread.sleep(3000);
            Reusable_Methods.click(driver, "//*[contains(text(),'SOLUTIONS')]", "Solutions");
            Thread.sleep(1500);
            //click on Metline Dental tab
            Reusable_Methods.click(driver, "//*[contains(text(),'MetLife TakeAlong Dental')]", "Take along Dental");
            Thread.sleep(3500);
            //click on Enroll Now button
            Reusable_Methods.click(driver, "//*[contains(text(),'Enroll Now')]", "Enroll Now");
            //define window handle for tabs
            Reusable_Methods.switchTab(driver, 1);
            Thread.sleep(4000);
            //enter zip code
            Reusable_Methods.type(driver, "//*[@id='txtZipCode']", postalCode.get(i), "Zip Code");
            //click on Go button
            Reusable_Methods.click(driver, "//*[text()='GO']", "Go");
            Thread.sleep(5500);

            //define javascriptexecutor to scroll on a page
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            //scrolling down to PPO type
            scroll.executeScript("scroll(0,700)");
            Thread.sleep(1000);
            //click on PPO-LOW, PPO-MEDIUM or PPO-HIGH
            driver.findElement(By.xpath("//*[@class='" + ppoType.get(i) + "']")).click();
            //click on Enroll In Program Now button
            driver.findElement(By.xpath("//*[contains(text(),'ENROLL IN PROGRAM NOW')]")).click();
            Thread.sleep(4000);
            //enter invalid referall code
            driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referallCode.get(i));
            //click on Go
            driver.findElement(By.xpath("//*[text()='GO']")).click();
            Thread.sleep(3000);
            //capture error message and verify it matches with your expected text
            String errMessage = driver.findElement(By.xpath("//*[contains(@id,'lblRefCodeError')]")).getText();
            if (errMessage.equals("Referral Code was not recognized")) {
                System.out.println("Referall code error message matches");
            } else {
                System.out.println("Referall code error doesn't match " + errMessage);
            }
            //click on Enroll witout a code
            driver.findElement(By.xpath("//*[text()='Enroll without a Referral Code']")).click();
            Thread.sleep(2000);
            //close your current tab which is second tab
            driver.close();
            //switch to first default tab
        }
    }
}
