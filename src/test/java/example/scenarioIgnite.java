package example;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.webapp.BasePage;

public class scenarioIgnite {

    private BasePage basePage;

    @Before("@start")
    public void setUp() {
        basePage = new BasePage();
    }

    @Given("^webpage is opened$")
    public void webpageIsOpened() throws Throwable {
        try {
            basePage.getDriver().get(basePage.getUrl());
        } catch (Throwable t) {
            System.out.println(t.getCause().toString());
        }
    }

    @Then("^client inputs (.*) username$")
    public void clientInputsUsername(String username) throws Throwable {
        try {
            basePage.userNameField.sendKeys(username);
        } catch (Throwable t) {
            System.out.println(t.getCause().toString());
        }
    }

    @And("^client inputs (.*) password$")
    public void clientInputsPassword(String password) throws Throwable {
        try {
            basePage.passwordField.sendKeys(password);
        } catch (Throwable t) {
            System.out.println(t.getCause().toString());
        }
    }

    @When("^client presses Login button$")
    public void clientPressesLoginButton() throws Throwable {
        try {
            basePage.loginButton.click();
        } catch (Throwable t) {
            System.out.println(t.getCause().toString());
        }
    }

    @Then("^client is logged in$")
    public void clientIsLoggedIn() throws Throwable {
        if (!basePage.adminPage.adminPageHeader.isDisplayed()) {
            Assert.assertTrue(basePage.userPage.userPageHeader.isDisplayed());
        }
    }

    @But("^system displays message about password change$")
    public void systemDisplaysMessageAboutPasswordChange() throws Throwable {
        try {
            basePage.wait.until(ExpectedConditions.visibilityOf(basePage.changePage.alertMessage));
        } catch (Throwable t) {
            System.out.println(t.getCause().toString());
        }

    }

    @And("^client changes password$")
    public void clientChangesPassword() throws Throwable {
        try {
            String newPassword = RandomStringUtils.randomAlphanumeric(6).toLowerCase();
            basePage.changePage.newPasswordInput.sendKeys(newPassword);
            basePage.changePage.confirmNewPasswordInput.sendKeys(newPassword);
            basePage.changePage.changePasswordButton.click();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
    }

    @Then("^summary of account balances is displayed$")
    public void summaryOfAccountBalancesIsDisplayed() throws Throwable {
        for (int i = 0; i < basePage.userPage.userAccounts.size(); i++) {
            WebElement row = basePage.userPage.userAccounts.get(i);
            try {
                Assert.assertTrue(row.isDisplayed());
            } catch (NegativeArraySizeException nae) {
                Assert.assertTrue(basePage.userPage.userPageHeader.isDisplayed());
            }
        }
    }
}
