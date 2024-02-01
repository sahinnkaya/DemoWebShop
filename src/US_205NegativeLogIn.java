import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US_205NegativeLogIn {
    public  void myWait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

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
        public void emptyLogin() {
            WebElement singEmail = driver.findElement(By.xpath("//input[@class='email']"));
            singEmail.sendKeys("");
            myWait(2);
            WebElement singPassword = driver.findElement(By.xpath("//input[@class='password']"));
            singPassword.sendKeys("");
          myWait(2);
            WebElement finishLogIn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
            finishLogIn.click();

            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }
        @Test
        public  void validEmailEmptyPassword(){
            WebElement singEmail = driver.findElement(By.xpath("//input[@class='email']"));
            singEmail.sendKeys("tanita.khokhlova@gmail.com");
            myWait(2);
            WebElement singPassword = driver.findElement(By.xpath("//input[@class='password']"));
            singPassword.sendKeys("");
            myWait(2);
            WebElement finishLogIn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
            finishLogIn.click();

            WebElement errorMessage = driver.findElement(By.xpath("(//div[@class='validation-summary-errors'])[1]"));
            Assert.assertTrue(errorMessage.isDisplayed());

        }
        @Test
        public  void emptyEmailValidPassword() {
            WebElement singEmail = driver.findElement(By.xpath("//input[@class='email']"));
            singEmail.sendKeys("");
            myWait(2);
            WebElement singPassword = driver.findElement(By.xpath("//input[@class='password']"));
            singPassword.sendKeys("QwertyQ123456 ");
            myWait(2);
            WebElement finishLogIn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
            finishLogIn.click();

            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }
        @Test
        public  void invalidPassword(){
            WebElement singEmail = driver.findElement(By.xpath("//input[@class='email']"));
            singEmail.sendKeys("tanita.khokhlova@gmail.com");
            myWait(2);
            WebElement singPassword = driver.findElement(By.xpath("//input[@class='password']"));
            singPassword.sendKeys("QwertyQ12");
            myWait(2);
            WebElement finishLogIn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
            finishLogIn.click();

            WebElement errorMessage = driver.findElement(By.xpath("(//div[@class='validation-summary-errors'])[1]"));
            Assert.assertTrue(errorMessage.isDisplayed());


        }
}
