package DemoWebShop;

// import Utilities.ReusableMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// import static Utilities.TestBase.driver;

public class US_203Logout {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        // Navigate to the URL https://demowebshop.tricentis.com/
        driver.get("https://demowebshop.tricentis.com/");
        // ReusableMethods.myWait(1);
    }

    @Test
    public void login() {
        // Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();
        // ReusableMethods.myWait(1);

        // Enter valid email
        WebElement emailToLogin = driver.findElement(By.xpath("//input[@class='email']"));
        emailToLogin.sendKeys("candiraliyee@gmail.com");
        // ReusableMethods.myWait(1);

        // Enter valid password
        WebElement passwordToLogin = driver.findElement(By.xpath("//input[@class='password']"));
        passwordToLogin.sendKeys("Aliye123");
        // ReusableMethods.myWait(1);

        // Enter Login button
        WebElement loginButtonToEnter = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginButtonToEnter.click();
        // ReusableMethods.myWait(1);

        // Enter the Logout button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        logoutButton.click();
        // ReusableMethods.myWait(1);
    }

    // @Test
    // public void logout() {
    // Enter the Logout button
    //     WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
    //     logoutButton.click();
    //     ReusableMethods.myWait(1);
    // }

    @After
    public void tearDown() {
        driver.get("https://demowebshop.tricentis.com/login");
    }





}
