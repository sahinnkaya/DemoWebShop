package DemoWebShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class US_201CreateUserAccount {
        WebDriver driver = new ChromeDriver();

        @Before
        public void setUp() {
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

            //Registration Completed
            WebElement registrationCompleted = driver.findElement(By.xpath("//div[@class='result']"));
            String expectedResult = "Your registration completed";
            String actualResult = registrationCompleted.getText();
            Assert.assertEquals(expectedResult, actualResult);
            //Continue
            WebElement continueButton = driver.findElement(By.xpath("//input[@type='button']"));
            continueButton.click();
        }
       /* @Test
        public void registrationCompleted(){
            //Registration Completed
            WebElement registrationCompleted = driver.findElement(By.xpath("//div[@class='result']"));
            String expectedResult = "Your registration completed";
            String actualResult = registrationCompleted.getText();
            Assert.assertEquals(expectedResult, actualResult);

            //Continue
            WebElement continueButton = driver.findElement(By.xpath("//input[@type='button']"));
            continueButton.click();
        }     */

        @After
        public void tearDown() {
            driver.quit();
        }
    }
