package stepdefinitions;

//import framework.TestSessionInitiator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ContextSteps {

    private static boolean initialized = false;

    WebDriver driver;

    LoginPageAction loginPageAction;
    NavigationBarAction navigationBarAction;

//    protected TestSessionInitiator testSession = new TestSessionInitiator();

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


   public void initializeobject(WebDriver driver, Scenario s){
        loginPageAction = new LoginPageAction(driver,s);
        navigationBarAction= new NavigationBarAction(driver,s);
    }

}

