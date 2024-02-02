package demowebshopUS208;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US209 {

    public static void main(String[] args) {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Open the website
            driver.get("https://demowebshop.tricentis.com/");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Press Login
            WebElement Loginbuttonhomepage = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
            Loginbuttonhomepage.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Log in to the account
            WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"Email\"]")); // Replace with your username input field ID
            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"Password\"]")); // Replace with your password input field ID
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")); // Replace with your login button ID

            // Enter username and password
            usernameInput.sendKeys("candiraliyee@gmail.com");
            passwordInput.sendKeys("Aliye123");
            loginButton.click();

            // Go to account
            WebElement myAccount = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
            myAccount.click();

            // Go to the Orders page
            WebElement orders = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div/div[2]/ul/li[3]/a"));
            orders.click();


            // Wait for the order history page to load
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Get the latest order number
            WebElement latestOrderNumber = driver.findElement(By.xpath("xpath for latest order"));
            String latestOrderNum = latestOrderNumber.getText();

            // Click on the latest order number
            latestOrderNumber.click();

            // Wait for the page to load
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Find invoice and click
            WebElement invoice = driver.findElement(By.xpath("xpath for invoice"));
            invoice.click();

            // Download the invoice
            WebElement downloadInvoiceButton = driver.findElement(By.xpath("xpath for download invoice "));
            downloadInvoiceButton.click();



        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}

