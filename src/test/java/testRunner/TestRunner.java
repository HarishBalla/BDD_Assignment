package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/java/features",
        monochrome = true,
        
        glue = {"stepsDefinition", "hooks"},
        plugin = {"hooks.CucumberListener",
                "pretty", "html:target/cucumber-reports/VeevaReport.html",
                "json:target/cucumber-reports/VeevaReport.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@DPtest2"
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
