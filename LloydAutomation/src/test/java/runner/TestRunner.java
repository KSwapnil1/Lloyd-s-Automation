package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/Feature/ARF_Journey.feature"
        ,glue = {"appHooks", "StepDef"}
        ,plugin = { "pretty","html:target/Cucumber-reports/ARFJourney.html" }
       // plugin ={
      //  "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        )

        public class TestRunner {
                TestRunner() {
                }
        }




















