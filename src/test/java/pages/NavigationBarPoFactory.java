package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class NavigationBarPoFactory {

	public NavigationBarPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(xpath="(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
	public MobileElement firstAvailableCart;

	@AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	public MobileElement viewToCart;

	@AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView")
	public MobileElement removeTheCart;



}
