package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LoginPagePoFactory  {
	public LoginPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"test-Username\"]")
	public MobileElement userNameTextField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"test-Password\"]")
	public MobileElement passwordTextField;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sign In\"])[2]")
	@AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	public MobileElement signButton;










}


