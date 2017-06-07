package pageObjects.webapp;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePage {

    @FindBy(css = ".alert.alert-warning")
    public WebElement alertMessage;

    @FindBy(css = "input[name='password']")
    public WebElement newPasswordInput;

    @FindBy(css = "input[name='confirmPassword']")
    public WebElement confirmNewPasswordInput;

    @FindBy(css = "button[name='change']")
    public WebElement changePasswordButton;
}
