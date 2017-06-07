package pageObjects.webapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage {

    @FindBy(xpath = "//h1[@class='page-header'and text='Accounts']")
    public WebElement userPageHeader;

    @FindBy(css = ".table.table-striped")
    public List<WebElement> userAccounts;
}
