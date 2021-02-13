package stepDefinition.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.junit.Assert;
import pageObjects.StepData;

import static io.restassured.RestAssured.given;

public class CommonSteps {

    private final StepData stepData;

    public CommonSteps(final StepData stepData){
        this.stepData = stepData;
    }

    @When("Send http post request")
    public void sendHttpPostRequest() {
        final RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addRequestSpecification(stepData.request);
        this.stepData.response = given(builder.build()).when().post(this.stepData.endPoint);
        this.stepData.response.getBody().prettyPrint();
        this.stepData.id = this.stepData.response.as(User.class).getId();
        this.stepData.response.getBody().prettyPrint();
    }

    @When("Send http delete request")
    public void sendHttpDeleteRequest() {
        final RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addRequestSpecification(stepData.request);
        this.stepData.response = given(builder.build()).when().delete(this.stepData.endPoint);
        this.stepData.response.getBody().prettyPrint();
    }

    @When("Send http get request")
    public void sendHttpGetRequest() {
        final RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addRequestSpecification(stepData.request);
        this.stepData.response =  given(builder.build()).when().get(this.stepData.endPoint);
        this.stepData.response.getBody().prettyPrint();
    }

    @Then("Check status code {string}")
    public void checkStatusCode(String statusCode) {
        Assert.assertEquals(this.stepData.response.getStatusCode(), Integer.parseInt(statusCode));
    }
}
