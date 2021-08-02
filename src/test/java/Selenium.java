import Roman.RomanBase;
import org.junit.Before;
import org.junit.Test;
import selenium.fix.FailingApplication;

public class Selenium extends RomanBase {

    @Before
    public void setup()
    {
        roman()._driver = roman().selenium.getChromeDriver();
    }

    @Test
    public void fixTests()
    {
        FailingApplication failingApplication = new FailingApplication(roman());

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
