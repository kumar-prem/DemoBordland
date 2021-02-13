package stepDefinition.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import pageObjects.StepData;

import java.util.Map;

public class GetUserListSteps {

    private final StepData stepData;

    public GetUserListSteps(final StepData stepData){
        this.stepData = stepData;
        this.stepData.setEndPoint("/api/users");
    }

    @Given("Prepare fetch user list")
    public void prepareFetchUserList(DataTable table) {
        Map<String, String> queryParams = table.asMap(String.class, Integer.class);
        final RequestSpecification requestSpec = this.stepData.request.given().queryParams(queryParams);
        this.stepData.setRequest(requestSpec);
    }

}
