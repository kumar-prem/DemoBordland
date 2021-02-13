package stepDefinition.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import pageObjects.StepData;

import java.util.Map;

public class DeleteUserSteps {
    private final StepData stepData;

    public DeleteUserSteps(final StepData stepData){
        this.stepData = stepData;
        this.stepData.setEndPoint("/api/users");
    }

    @Given("Prepare delete user request")
    public void prepareRegisterUserRequest() {
        final RequestSpecification requestSpec = this.stepData.request.given().param(this.stepData.id);
        this.stepData.setRequest(requestSpec);
    }
}
