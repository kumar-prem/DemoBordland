package pageObjects;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class StepData {
    public RequestSpecification request;
    public Response response;
    public WebDriver driver;
    public String endPoint;
    public String id;
    public String token;
}
