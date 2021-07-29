package selenium.fix;

import Roman.Roman;
import org.openqa.selenium.WebDriver;
import selenium.fix.pages.AccountDashboardPage;
import selenium.fix.pages.LoginPage;

public class FailingApplication {

    public LoginPage LoginPage;
    public AccountDashboardPage AccountDashboardPage;

    public FailingApplication(Roman roman)
    {
        LoginPage = new LoginPage(null);
        AccountDashboardPage = new AccountDashboardPage(roman);
    }
}
