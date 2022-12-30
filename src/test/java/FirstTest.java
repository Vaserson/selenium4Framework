import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest{
    BaseTest baseTest;

    @BeforeClass
    public void beforeClass() {
        baseTest = new BaseTest();
        baseTest.initializeDriver();
    }

    @AfterClass
    public void afterClass() {
        baseTest.quitDriver();
    }

    @Test
    public void googleSearchTest() throws InterruptedException {

        driver.get("https://google.com");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        Assert.assertTrue(
                driver.findElement(By.partialLinkText("Selenium")).isDisplayed());
//        driver.quit();
    }

    @Test
    public void yahooSearchTest() throws InterruptedException {
        driver.get("https://yahoo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("p")).sendKeys("Selenium");
        Thread.sleep(3000);
        driver.findElement(By.name("p")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Assert.assertTrue(
                driver.findElement(By.partialLinkText("Selenium")).isDisplayed());
//        driver.quit();
    }
}
