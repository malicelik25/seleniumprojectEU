package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getText_getAttribute {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome"); //we created this method inside utilities
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)) {
            System.out.println("Remember me label verification PASSED");
        } else {
            System.err.println("Remember me label verification FAILED!!!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPassword = "Forgot your password?";
        String actualForgotPassword = forgotPassword.getText();

        if (actualForgotPassword.equalsIgnoreCase(expectedForgotPassword)) {
            System.out.println("Forgot password verification PASSED");
        } else {
            System.err.println("Forgot password verification FAILED");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualHrefAttributeValue = forgotPassword.getAttribute("href");

        if (actualHrefAttributeValue.contains(expectedInHref)) {
            System.out.println("HREF attribute value verification PASSED");
        } else {
            System.err.println("HREF attribute value verification FAILED");
        }


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.


    }

}
/*






 */