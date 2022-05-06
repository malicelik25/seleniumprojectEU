package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        //WebElement loginButton = driver.findElement(By.className("login-btn"));

        //LOCATING THE SAME WEB ELEMENT USING DIFFERENT ATTRIBUTE VALUES.
        //using cssSelector                tagName[attribute='value']  we do not have to use class
        //using cssSelector                input[class='login-btn']    we can use all the attributes in cssSelector
        // LOCATED USING CLASS ATTRIBUTE
        //WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));
        // LOCATED USING TYPE ATTRIBUTE
        //WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        // LOCATED USING VALUE ATTRIBUTE
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedLoginButton = "Log In";

        //Getting the value of the attribute "value"
        String actualLoginButton = loginButton.getAttribute("value");
        //getText();--> can only get between opening and closing tag
        System.out.println("actualLoginButton = " + actualLoginButton);

        if (actualLoginButton.equals(expectedLoginButton)) {
            System.out.println("Login button text verification PASSED");
        } else {
            System.err.println("Login button text verification FAILED!!!");
        }


    }

}
