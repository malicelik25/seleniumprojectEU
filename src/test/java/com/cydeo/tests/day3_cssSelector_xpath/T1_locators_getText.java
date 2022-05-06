package com.cydeo.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");

        //3- Enter incorrect username: “incorrect”
        WebElement incorrectUsername = driver.findElement(By.name("USER_LOGIN"));
        incorrectUsername.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement incorrectPassword = driver.findElement(By.name("USER_PASSWORD"));
        incorrectPassword.sendKeys("incorrect");

        //5- Click to log-in button.
        WebElement clickLogin = driver.findElement(By.className("login-btn"));
        clickLogin.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText(); // we got the error message with getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Incorrect verification PASSED");
        } else {
            System.err.println("Incorrect verification FAILED!!!");
        }


    }


}