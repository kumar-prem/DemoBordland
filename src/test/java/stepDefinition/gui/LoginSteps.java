package stepDefinition.gui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.StepData;

public class LoginSteps {

    private final StepData stepData;
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(final StepData stepData) {
        this.stepData = stepData;
        this.driver = stepData.driver;
        loginPage = new LoginPage(this.driver);
    }

    @Given("User Enters {string} and {string}")
    public void userEntersAnd(String email, String password) {
        loginPage.loginToApplication(email, password);
    }

    @When("Clicks on LogIn button")
    public void clicksOnLogInButton() {
        loginPage.getBtnLogin().click();
    }

    @Then("User Sees details page")
    public void userSeesDetailsPage() {
        Assert.assertTrue(loginPage.getBtnLogout().isDisplayed());
    }

    @Then("User Sees Error Message")
    public void userSeesErrorMessage() {
        Assert.assertTrue(loginPage.getFrameLoginForm().getText().contains("Could not log in user: Internal Error"));
    }

    @Then("User Sees logout button on details page")
    public void userSeesLogoutButtonOnDetailsPage() {
        Assert.assertTrue(loginPage.getBtnLogout().isDisplayed());
    }
}
