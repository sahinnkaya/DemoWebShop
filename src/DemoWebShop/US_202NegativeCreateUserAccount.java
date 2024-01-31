package DemoWebShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US_202NegativeCreateUserAccount {
    WebDriver driver = new ChromeDriver();
    @Before
    public void setUp(){
        //Navigate to website.
        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }


    @Test
    public void createUserAccount() {
        // I should be able to click “Register” button on the homepage.
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerButton.click();

        //Registration step. Choose gender
        WebElement genderButton = driver.findElement(By.xpath("//label[@for='gender-female']"));
        genderButton.click();
        //Firstname
        WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName.sendKeys("Aliye");
        //LastName
        WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("Candir");
        //E-mail
        WebElement eMail = driver.findElement(By.xpath("//input[@name='Email']"));
        eMail.sendKeys("candiraliyee@gmail.com");
        //Password
        WebElement passWord = driver.findElement(By.xpath("//input[@name='Password']"));
        passWord.sendKeys("Aliye123");
        //Confirm password
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        confirmPassword.sendKeys("Aliye123");
        //Click "Register"-Button to confirm
        WebElement registerButtonAfterConfirm = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerButtonAfterConfirm.click();

    }


    @Test
    public void errorMessage(){
        //Error Message with existing email account//
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='message-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
