package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {

    public static void main(String[] args) {

        //TC #2: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
        //driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestingLink = driver.findElement(By.linkText("A/B Testing"));//we located and stored this element
        abTestingLink.click();

        //4- Verify title is:
        //Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

        //5- Go back to home page by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Practice
        String expectedTitle2 = "Practice";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println("Title verification 2 PASSED!");
        } else {
            System.out.println("Title verification 2 FAILED!!!");
        }


    }

}
/*
TC #2: Back and forth navigation
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */