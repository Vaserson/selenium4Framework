import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    String browser = System.getProperty("browser"); // to start from terminal::::: mvn test -Dbrowser=CHROME

    protected WebDriver initializeDriver() {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
