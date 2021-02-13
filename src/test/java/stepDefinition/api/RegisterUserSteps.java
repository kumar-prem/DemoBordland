package stepDefinition.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import pageObjects.StepData;

import java.util.Map;

public class RegisterUserSteps {
    private final StepData stepData;

    public RegisterUserSteps(final StepData stepData){
        this.stepData = stepData;
        this.stepData.setEndPoint("/api/register");
    }

    @Given("Prepare register user request")
    public void prepareRegisterUserRequest(DataTable table) {
        Map<String, String> body = table.asMap(String.class, String.class);
        final RequestSpecification requestSpec = this.stepData.request.given().body(body);
        this.stepData.setRequest(requestSpec);
    }
}
