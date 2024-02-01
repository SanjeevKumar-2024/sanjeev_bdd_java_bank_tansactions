package stepDefinations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/manageBankTransactions_E2E.feature", 
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
glue= {"StepDefinitions"},
monochrome= true)
public class RunCucumberTest {

}
