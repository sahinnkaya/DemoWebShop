package DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import java.time.Duration;
import org.junit.Before;

public class US_204LogInPos {

        WebDriver driver;

        @Before
        public void setUp(){
            driver =  new ChromeDriver();
            driver.get("https://demowebshop.tricentis.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement logInButton = driver.findElement(By.xpath("//a[@href='/login']"));
            logInButton.click();
        }
        @Test
        public void logIn() {
            WebElement logInButton = driver.findElement(By.xpath("//a[@href='/login']"));
            logInButton.click();

            WebElement singEmail = driver.findElement(By.xpath("//input[@class='email']"));
            singEmail.sendKeys("tanita.khokhlova@gmail.com");

            WebElement singPassword = driver.findElement(By.xpath("//input[@class='password']"));
            singPassword.sendKeys("QwertyQ123456");

            WebElement finishLogIn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
            finishLogIn.click();

        }

}
