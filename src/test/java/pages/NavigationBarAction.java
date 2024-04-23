package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class NavigationBarAction extends BasePage {

	private NavigationBarPoFactory navigationBarPoFactory;
	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public NavigationBarAction(WebDriver driver, Scenario scn) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		navigationBarPoFactory = new NavigationBarPoFactory(appiumDriver);
//		currentClassName = getCurrentClassName();
	}
	public void click_on_first_available_cart(){
		navigationBarPoFactory.firstAvailableCart.click();
		sleep(3000);
	}

	public void click_on_the_view_to_cart_and_remove(){
		navigationBarPoFactory.viewToCart.click();
		sleep(2000);
		navigationBarPoFactory.removeTheCart.click();
	}
}
