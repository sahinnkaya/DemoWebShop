package DemoWebShop;

// import Utilities.ReusableMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// import static Utilities.TestBase.driver;

public class US_207SurveyResponse {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        // 1-Navigate to the URL https://demowebshop.tricentis.com/
        driver.get("https://demowebshop.tricentis.com/");
        // ReusableMethods.myWait(2);
    }

    @Test
    public void communityPoolSurveyWithoutLogin() {
        // We have 4 option to choose: locator1(Excellent), locator2(Good), locator3(poor), locator4(Very Bad)
        WebElement chooseOfFeedback = driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
        chooseOfFeedback.click();
        // ReusableMethods.myWait(1);

        // Click on vote button
        WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        voteButton.click();
        // ReusableMethods.myWait(1);

        // Display message after click on vote without login
        WebElement message = driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void communityPoolSurveyWithLogin() {
        // Display title of Community Pool
        WebElement titleOfCommunityPool = driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        Assert.assertTrue(titleOfCommunityPool.isDisplayed());
        // ReusableMethods.myWait(1);

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

        // Display result of survey
        WebElement resultOfSurvey = driver.findElement(By.xpath("//div[@id='poll-block-1']"));
        Assert.assertTrue(resultOfSurvey.isDisplayed());
        // ReusableMethods.myWait(1);
    }

}
