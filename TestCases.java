package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.core5.http.nio.entity.NoopEntityConsumer;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        // 2. Load URL :https://www.google.com/
        driver.get("https://www.google.com/");
        // 3. Locate search bar and Search "Amazon" in the search bar Using Locator "XPath":"//input[@aria-label='Search']" / sendKeys("Amazon");
        WebElement searchBar = driver.findElementByXPath("//input[@aria-label='Search']");
        searchBar.sendKeys("Amazon");
        // 4 Click Enter in the search bar after entering text :sendkeys(keys.ENTER);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // 5. Locate the first Search Result text Using Locator "XPath":"(//span[@class='VuuXrf'])[1]" / getText(); //(//h3[@class='LC20lb MBeuO DKV0Md'])[1]
        WebElement firstsearchResultText = driver.findElementByXPath("(//span[@class='VuuXrf'])[1]");
        Thread.sleep(2000);
        System.out.println("The Search Result  Text is : " +firstsearchResultText.getText());

        Thread.sleep(1000);

        //6. Locate the first search result and return the text of the link Using Locator "XPath":"(//span[@role='text'])[1]" / getText();
        WebElement firstsearchResulLinktText = driver.findElementByXPath("(//span[@role='text'])[1]");
        Thread.sleep(2000);
        System.out.println("The Search Result Link text is : " +firstsearchResulLinktText.getText());

        //7. Locate the first Search Result Link Using Locator "XPath":"(//div[@class='yuRUbf']//a)[1]" / getAttribute("href")
        WebElement firstsearchResultLink = driver.findElementByXPath("(//div[@class='yuRUbf']//a)[1]");
        Thread.sleep(2000);
        System.out.println("The Search Result link is : " +firstsearchResultLink.getAttribute("href"));

        
     
    }


}
