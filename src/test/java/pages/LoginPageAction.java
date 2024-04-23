package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static com.demo.framework.Utils.ConfigReader.*;
public class LoginPageAction extends BasePage{
	Scenario scn;
	private LoginPagePoFactory loginPagePoFactory;
	AppiumDriver<MobileElement> appiumDriver;
	@SuppressWarnings("unchecked")
	public LoginPageAction(WebDriver driver, Scenario s) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		loginPagePoFactory = new LoginPagePoFactory(appiumDriver);
		this.scn =s;
	}

	public void signInToApp() {
		sleep(3000);
		waitForElementToBecomeVisible(loginPagePoFactory.userNameTextField, 2);
		loginPagePoFactory.userNameTextField.click();
		loginPagePoFactory.userNameTextField.sendKeys(AppUSERNAME);
		sleep(3000);
		waitForElementToBecomeVisible(loginPagePoFactory.passwordTextField, 6);
		loginPagePoFactory.passwordTextField.click();

		waitForElementToBecomeVisible(loginPagePoFactory.passwordTextField, 10);
		System.out.println(AppPassword);
		loginPagePoFactory.passwordTextField.sendKeys(AppPassword);

//		if(PlatformName.equalsIgnoreCase("Android")) {
//			appiumDriver.hideKeyboard();
//		}
		loginPagePoFactory.signButton.click();

	}







}
