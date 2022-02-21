import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.fix.FailingApplication;

public class Selenium  {

    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

    @Test
    public void fixTests()
    {
        FailingApplication failingApplication = new FailingApplication(driver);

        failingApplication.LoginPage.login("Harry Potter");
        failingApplication.AccountDashboardPage.depositAndValidate("1004","12345");
        failingApplication.AccountDashboardPage.logout();

    }

    @Test
    public void transactionValidation()
    {
        //Make a deposit of 500
        //Make a deposit of 444
        //Navigate to the transactions page and validate the transactions in the grid
    }
}
