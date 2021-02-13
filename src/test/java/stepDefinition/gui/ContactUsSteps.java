package stepDefinition.gui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AutoQuotePage;
import pageObjects.ContactUsPage;
import pageObjects.StepData;

public class ContactUsSteps {

    private final StepData stepData;
    private WebDriver driver;
    private ContactUsPage contactUsPage;

    public ContactUsSteps(final StepData stepData){
        this.stepData = stepData;
        this.driver = this.stepData.driver;
        contactUsPage = new ContactUsPage(this.driver);
    }

    @Given("User Clicks on Contact Us Link")
    public void userClicksOnContactUsLink() {
        contactUsPage.clickContactUsLink();
    }

    @And("User is on Contact Us Page")
    public void userIsOnContactUsPage() {
        contactUsPage.verifyContactUsPageIsOpen();
    }

    @And("Clicks on Submit button")
    public void clicksOnSubmitButton() {
        contactUsPage.clickSubmitLink();
    }

    @Then("User Navigates back to HomePage")
    public void userNavigatesBackToHomePage() {
        contactUsPage.verifyContactUsFormIsSubmitted();
    }

    @When("Enters Personal Details like {string} {string} and {string}")
    public void entersPersonalDetailsLikeAnd(String title, String firstname, String lastname) {
        contactUsPage.fillContactUsPersonalDetails(title, firstname, lastname);
    }

    @And("Enters Contact Details like {string} {string} {string} {string} {string} and {string}")
    public void entersContactDetailsLikeAnd(String address, String city, String state, String zipcode, String telephone, String email) {
        contactUsPage.fillContactUsContactDetails(address, city, state, zipcode, telephone, email);
    }

    @And("When Enters {string}")
    public void whenEnters(String comment) {
        contactUsPage.fillContactUsComment(comment);
    }
}
