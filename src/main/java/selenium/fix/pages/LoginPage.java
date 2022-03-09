package selenium.fix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.AbstractPage;

public class LoginPage extends AbstractPage {

    private By CustomerLoginBtn = By.xpath("//button[text()='Customer Login']");
    private By NameSelect = By.id("userSelect");
    private By LoginBtn = By.xpath("");


    public LoginPage(WebDriver driver) {
               super(driver);
        this._driver=driver;
    }

    public void login(String customerName)
    {
        navigate("http://www.way2automation.com/angularjs-protractor/banking/#/login");
        waitForDisplayed();
        click(CustomerLoginBtn);
        selectFromDropdown(NameSelect, customerName);
        click(LoginBtn);

    }

    public void selectFromDropdown(By select, String text)
    {
        throw new UnsupportedOperationException();
    }

    public boolean waitForDisplayed() {
        return validateElement_Enabled_Displayed(CustomerLoginBtn);
    }

}
