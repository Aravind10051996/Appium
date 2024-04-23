package stepdefinitions;



import com.demo.framework.Factory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class Loginsteps {

	ContextSteps contextSteps;
	WebDriver driver;
//	TestSessionInitiator testSession;
	Scenario scn;
	DriverFactory factory = new DriverFactory();

	// PicoContainer ContextSteps
	public Loginsteps(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
	}

	@Given("^App is launched$")
	public void launchApp() {
//		testSession = new TestSessionInitiator();
//		driver = testSession.getWebDriver();
		driver = factory.createDriverInstance();
//		contextSteps.getDriver();
		contextSteps.setDriver(driver);
		contextSteps.initializeobject(driver, scn);
	}

	@Given("I sign in the Application")
	public void i_sign_in_the_Application() {
//		loginPageAction.signInToApp();
		contextSteps.loginPageAction.signInToApp();
	}
}
//
//	@Before
//	public void SetUp(Scenario s){
//		this.scn=s;
//
//	}

