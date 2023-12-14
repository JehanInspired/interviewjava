package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    public WebDriver _driver;

    public AbstractPage(WebDriver driver)
    {
        _driver = driver;
    }

    public WebElement findOne(By by, int ... waitTimeout)
    {
        int localTimeout = (waitTimeout != null && waitTimeout.length > 0) ? waitTimeout[0] : 30;
        WebDriverWait wait = new WebDriverWait(_driver, localTimeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> find(By by)
    {
        WebDriverWait wait = new WebDriverWait(_driver, 5);
        return wait.until(drv -> drv.findElements(by));
    }

    public String getAttribute(By by, String attribute)
    {
        return findOne(by).getAttribute(attribute);
    }

    public String getText(By by)
    {
        return findOne(by).getText();
    }

    public void click(By by)
    {
        findOne(by).click();
    }

    public void sendKeys(By by, String text)
    {
        findOne(by).sendKeys(text);
    }

    public void navigate(String url)
    {
        _driver.navigate().to(url);
    }

    public void setSelectedItem(By by, String text)
    {
        Select select = new Select(findOne(by));
        select.selectByVisibleText(text);
    }

    public boolean validateElement_Enabled_Displayed(By by)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(_driver, 5);
            wait.until(drv -> drv.findElement(by)).isEnabled();
            wait.until(drv-> drv.findElement(by)).isDisplayed();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    public boolean validateElement_Enabled_Displayed(By by, int timeout)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(_driver, timeout);
            wait.until(drv -> drv.findElement(by)).isEnabled();
            wait.until(drv-> drv.findElement(by)).isDisplayed();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}
