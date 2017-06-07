package pageObjects.webapp;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

    @FindBy(xpath = "//h1[@class='page-header' and text='Clients']")
    public WebElement adminPageHeader;
}
