import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue={"stepDefinition"},
        plugin = {"json:target/cucumber-reports/Cucumber.json",
        "de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports/Cucumber"},
        tags = "@API or @GUI"
)
public class CucumberTestRunner {

}
