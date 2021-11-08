package selenium.fix.pages;

import Roman.Roman;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import selenium.AbstractPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDashboardPage extends AbstractPage {

    private By DepositBtn = By.xpath("//button[contains(text(),'Deposit')]");

    private By DepositInput = By.xpath("//input[@type='number']");
    private By Deposit = By.xpath("//button[text()='Deposit']");
    private By DepositSuccess = By.xpath("//span[text()='Deposit Successful']");
    private By AccountDetails = By.xpath("//div[contains(text(),'Account Number :')]");
    private By LogoutButton = By.xpath("//button[text()='Logout']");
    private By AccountSelector = By.id("accountSelect");


    public AccountDashboardPage(Roman roman) {
        super(roman);
    }

    public void logout()
    {
        click(LogoutButton);
        stepPassedWithScreenshot("Logout complete");
    }

    private String balanceDifference(String balanceAfter, String balanceBefore)
    {
        int diff = Integer.parseInt(balanceAfter)- Integer.parseInt(balanceBefore);
        return diff+"";
    }

    public void depositAndValidate(String account, String amount)
    {

        setSelectedItem(AccountSelector,account);

        stepPassedWithScreenshot("Account Page Loaded");
        click(DepositBtn);

        String accountBefore = getText(AccountDetails);
        //Provide Regex for this pattern
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(accountBefore);
        String balanceBefore = "";
        if(matcher.find())
        {
            balanceBefore = matcher.group(0);
        }

        stepInfo("Balance Before: "+balanceBefore);

        sendKeys(DepositInput, amount);
        click(Deposit);
        validateElement_Enabled_Displayed(DepositSuccess,15);
        stepPassedWithScreenshot("Deposit success");

        String accountAfter = getText(AccountDetails);
        matcher = pattern.matcher(accountAfter);
        String balanceAfter = "";
        if(matcher.find())
        {
            balanceAfter = matcher.group(0);
        }

        stepInfo("Balance After: "+balanceAfter);

        String difference = balanceDifference(balanceAfter,balanceBefore);

        Assertions.assertTrue(!amount.equals(difference),"Deposit difference failed to validate, expected "+amount+
                ", but found "+difference);

        stepPassedWithScreenshot("Deposit difference validated successfully");
    }


    @Override
    protected String get_uri() {
        return null;
    }

    public boolean waitForDisplayed() {
        return validateElement_Enabled_Displayed(DepositBtn);
    }

}
