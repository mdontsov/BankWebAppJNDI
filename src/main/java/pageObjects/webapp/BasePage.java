package pageObjects.webapp;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import pageObjects.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BasePage extends DriverFactory {

    public String getUrl() {
        return "http://localhost:8080/BankWebApp";
    }

    @FindBy(css = "input[name='username']")
    public WebElement userNameField;

    @FindBy(css = "input[name='password']")
    public WebElement passwordField;

    @FindBy(css = "button[name='submit']")
    public WebElement loginButton;

    public BasePage() {
        super();
        PageFactory.initElements(webDriver, this);
    }

    public AdminPage adminPage = PageFactory.initElements(getDriver(), AdminPage.class);
    public UserPage userPage = PageFactory.initElements(getDriver(), UserPage.class);
    public ChangePage changePage = PageFactory.initElements(getDriver(), ChangePage.class);

    public FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
            .withTimeout(5, TimeUnit.SECONDS)
            .pollingEvery(1, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    public WebDriver getDriver() {
        return webDriver;
    }
}
