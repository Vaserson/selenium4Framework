import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void googleSearchTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Assert.assertTrue(
                driver.findElement(By.partialLinkText("Selenium")).isDisplayed());
        driver.quit();
    }

    @Test
    public void yahooSearchTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://yahoo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("p")).sendKeys("Selenium");
        driver.findElement(By.name("p")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        Assert.assertTrue(
                driver.findElement(By.partialLinkText("Selenium")).isDisplayed());
        driver.quit();
    }

    @Test
    public void firefoxGoogleSearchTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");
        FirefoxBinary binary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions()
                .setBinary(binary);

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        Assert.assertTrue(
                driver.findElement(By.partialLinkText("Selenium")).isDisplayed());
        driver.quit();
    }
}
