package step_definitions;

import commonUtils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui_utils.Driver;
import ui_utils.Selenium_utils;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static Scenario currentScenario;


    @Before
    public void setUp(Scenario scenario) {
        Driver.get().get(ConfigReader.readProperty("projectURL"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Selenium_utils.takeScreenshot();
        }
        Driver.closeDriver();
    }
}


