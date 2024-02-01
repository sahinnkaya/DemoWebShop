package DemoWebShop;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class US_206Ordering{


WebDriver driver;

        @Before
        public void setUp() {

            driver = new ChromeDriver();
            driver.get("https://demowebshop.tricentis.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        @Test
        public void testWebshopOrder() {
            WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
            login.click();


            WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            email.sendKeys("aniasagan99@gmail.com");

            WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            password.sendKeys("Qwerty123");

            WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            login2.click();


            WebElement addToCart = driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            addToCart.click();

            WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
            shoppingCart.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement iframeElement = driver.findElement(By.xpath("//input[@id='termsofservice']"));
            iframeElement.click();

            WebElement checkout = driver.findElement(By.xpath("//button[@class='button-1 checkout-button']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            checkout.click();


            WebElement countryList = driver.findElement(By.xpath("//select[@name='BillingNewAddress.CountryId']"));
            Select selectCountry = new Select(countryList);
            selectCountry.selectByVisibleText("United States");


            WebElement city = driver.findElement(By.xpath("//input[@name='BillingNewAddress.City']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            city.sendKeys("Hollywood");

            WebElement adress = driver.findElement(By.xpath("//input[@name='BillingNewAddress.Address1']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            adress.sendKeys("914 South Southlake Drive");


            WebElement zip = driver.findElement(By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            zip.sendKeys("33019");

            WebElement phone = driver.findElement(By.xpath("//input[@name='BillingNewAddress.PhoneNumber']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            phone.sendKeys("(305)780-3089");


            driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]")).click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement pickUpInStore = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
            pickUpInStore.click();

            driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebElement confirmOrder = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
            confirmOrder.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebElement orderDetails = driver.findElement(By.xpath("(//a[normalize-space()='Click here for order details.'])[1]"));
            orderDetails.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            System.out.println("Your Order Has Been Successfully Processed!");


            driver.quit();


        }
    }


