package selenium.fix.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.AbstractPage;

public class LoginPage extends AbstractPage {

    private By CustomerLoginBtn = By.xpath("//button[text()='Customer Login']");
    private By NameSelect = By.id("userSelect");
    private By LoginBtn = By.xpath("");


    public LoginPage(Roman roman) {
        super(roman);
    }

    @Override
    protected String get_uri() {
        return "http://www.way2automation.com/angularjs-protractor/banking/#/login";
    }

    public void login(String customerName)
    {
        navigateTo();
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
