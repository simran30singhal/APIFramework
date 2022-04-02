package cucmberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/home/simransinghal30/eclipse-workspace/APIFramework/src/test/java/features", glue= "stepDefinitions", 
				 plugin= {"json:target/jsonReports/cucumber-report.json"})
public class TestRunner {

}
