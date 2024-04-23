package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AppHooks {

    ContextSteps contextSteps;
    public AppHooks (ContextSteps contextSteps) {
        this.contextSteps = contextSteps;
    }

//    @Before(order = 1)
//    public void launchBrowser() {
//        String browserName = prop.getProperty("browser");
//        driverFactory = new DriverFactory();
//        driver = driverFactory.init_driver(browserName);
//
//    }

    @After(order = 0)
    public void quitBrowser() {
        contextSteps.getDriver().quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
//       // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) contextSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

    @AfterStep(order = 0)
    public void afterStep(Scenario scenario) {
        // take screenshot:
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) contextSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenshotName);
    }
}
