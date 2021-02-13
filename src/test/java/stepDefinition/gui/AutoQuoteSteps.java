package stepDefinition.gui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AutoQuotePage;
import pageObjects.StepData;

public class AutoQuoteSteps {

    private final StepData stepData;
    private WebDriver driver;
    private AutoQuotePage autoQuotePage;

    public AutoQuoteSteps(final StepData stepData){
        this.stepData = stepData;
        this.driver = this.stepData.driver;
        autoQuotePage = new AutoQuotePage(this.driver);
    }
    @Given("User Selects Auto Quote Service from Service List")
    public void userSelectsAutoQuoteServiceFromServiceList() {
        autoQuotePage.selectAutoQuoteService();
    }

    @When("Enters {string} and {string}")
    public void entersAnd(String zipcode, String email) {
        autoQuotePage.enterGetInstantAutoQuoteForm(zipcode, email);
    }

    @And("Selects {string}")
    public void selects(String automobiletype) {
        autoQuotePage.selectAutoMobileType(automobiletype);
    }

    @And("Clicks on Next button")
    public void clicksOnNextButton() {
        autoQuotePage.clickNextButton();
    }

    @Then("Instant Auto Quote Form is Open")
    public void instantAutoQuoteFormIsOpen() {
        autoQuotePage.verifyInstantAutoQuotePageIsOpen();
    }

    @And("User Enters {string} {string} and {string}")
    public void enterInstantAutoQuoteDetails1(String age, String gender, String drivingRecord) {
        autoQuotePage.enterInstantAutoQuoteDetails1(age, gender, drivingRecord);
    }

    @And("User Enters {string} {string} {string} and {string}")
    public void enterInstantAutoQuoteDetails2(String year, String make, String model, String financialinfo) throws InterruptedException {
        autoQuotePage.enterInstantAutoQuoteDetails2(year, make, model, financialinfo);
    }

    @Then("Gets Automobile Instant Quote")
    public void getsAutomobileInstantQuote() {
        autoQuotePage.getInstantQuoteInformation();
    }
}
