package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_window_test() {
        //Storing the main page's window handle as string is good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //3. Assert: Title is “Windows”
        String ecpectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, ecpectedTitle);

        System.out.println("Title before click: " + actualTitle);

        //4. Click to: “Click Here” link
        WebElement clickHereButton = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereButton.click();

        //5. Switch to new Window.
        Set<String> allWindowsHandles = driver.getWindowHandles();
        //window handle 1 - main window
        //window handle 2 - 2nd window

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

        //6. Assert: Title is “New Window”
        String ecpectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, ecpectedTitleAfterClick);

        System.out.println("Title after click: " + actualTitle);

        //If we want to go back to main page, we can use already stored main handle
        //driver.switchTo().window(mainHandle);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

        //driver.close(); closes current window

        driver.quit();//closes everything
    }

}
