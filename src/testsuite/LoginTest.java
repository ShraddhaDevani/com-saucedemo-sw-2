package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter the email to email field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // //Enter the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.xpath("//input[@id= 'login-button']")).click();

        //Verify the text “Swag Labs”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class= 'title']")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter the email to email field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // //Enter the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.xpath("//input[@id= 'login-button']")).click();

        //Verify that six products are displayed on page
        List<WebElement> linksElements = driver.findElements(By.xpath("//a[@id='item_4_img_link']/img"));
        System.out.println("Number of links " + linksElements.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}