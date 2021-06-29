package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilities.ReadProperties.getProperty;

public class TestBase {

    WebDriver driver;

    @BeforeSuite
    public void setup() throws IOException{
        String BaseURL = getProperty("baseUrl");
        String Browser = getProperty("targetBrowser");
        Browser = Browser.toLowerCase();
        if (Browser.toLowerCase().contains("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("disable-notifications");
            driver = new ChromeDriver(option);

        } else if (Browser.toLowerCase().contains("ie")) {
            driver = new
                    InternetExplorerDriver();
        } else {
            System.out.println("browser : " + Browser + " is invalid, Launching Firefox as browser of choice..");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(BaseURL);


    }

    @AfterMethod
    public void tearDown() {
        //  driver.close();
        //pressing Logout Option
        // click on Account option
//        driver.findElement(By.cssSelector("div[aria-label='Account']")).click();
//        //click on log out
//        driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
        driver.close();
        driver.quit();
    }

    @DataProvider(name="userData")
    public Object[][] getUserData() throws Exception
    {
        return new Object[][] {
                {"dharmender86@hotmail.com","Ruhi#1234"},
        };
    }
}
