package stepDefinition;


import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.StepData;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private final StepData stepData;
    private WebDriver driver;

    public Hooks(final StepData stepData){
        this.stepData = stepData;
    }

    @Before("@GUI and not @API")
    public void initGUI(Scenario scenario) {
        System.out.println("@Before scenario");
        WebDriverManager.chromedriver().setup();
        stepData.driver = new ChromeDriver();
        stepData.driver.navigate().to("http://demo.borland.com/InsuranceWebExtJS/index.jsf");
        stepData.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        stepData.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @After("@GUI and not @API")
    public void cleanUpGUI(Scenario scenario) {
        System.out.println("@After scenario");
        stepData.driver.close();
        stepData.driver.quit();
    }

    @Before("@API and not @GUI")
    public void initAPI(Scenario scenario) {
        System.out.println("@Before scenario");
        this.stepData.request = RestAssured.with();
        RestAssured.useRelaxedHTTPSValidation();
        this.stepData.request.baseUri("https://reqres.in/");
    }

    @After("@API and not @GUI")
    public void cleanUpAPI(Scenario scenario) {
        System.out.println("@After scenario");
    }
}
