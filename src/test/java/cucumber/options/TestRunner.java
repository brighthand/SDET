package cucumber.options;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import io.cucumber.core.*;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", plugin = "json:target/jsonReports/cucumber-report.json", glue = {"stepDefinitions"})
public class TestRunner {

}
