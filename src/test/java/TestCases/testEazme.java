package TestCases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.awt.*;


public class testEazme extends TestBase{

    @Test(dataProvider = "userData")
    public void LogIn(String username, String password) throws AWTException, InterruptedException {
        System.out.println(username +"======="+ password);
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#login_email")).sendKeys(username);

        driver.findElement(By.cssSelector("#login_password")).sendKeys(password);

        driver.findElement(By.cssSelector("div[class='mt-5 sign-border-section'] button[type='submit']")).click();




    }


}
