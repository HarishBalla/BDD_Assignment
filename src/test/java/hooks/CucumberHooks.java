package hooks;

import driver.DriverManager;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {
	public static Properties OR;
	public static WebDriver driver=null;
    @BeforeAll
    public static void beforeAll() {
    }

    @AfterAll
    public static void afterAll() {

    }

    @Before
    public void beforeScenario() {
    }

//    @After
//    public void afterScenario(Scenario scenario) {
//        DriverManager.quit();
//    }


    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
    }

}
