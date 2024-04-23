package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * A base for all the pages within the suite
 */
public abstract class BasePage {
   
    /**
     * The driver
     */
//    AndroidDriver<MobileElement> driver;
    AppiumDriver<MobileElement> appiumDriver;

    @SuppressWarnings("unchecked")
    public BasePage(WebDriver appiumDriver) {
        this.appiumDriver = (AppiumDriver<MobileElement>) appiumDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement waitForElementToBecomeVisible(MobileElement element, int waitInSeconds) {
        new WebDriverWait(appiumDriver, waitInSeconds).until(ExpectedConditions.visibilityOf(element));
//        Reporter.log(getCurrentClassName() + " Element is found to be visible " + element.toString(), true);
        return element;
    }

    public void explicitWaitForElementToBeClickable(MobileElement mobileElement, int seconds){
        waitForElementToBeClickable(mobileElement, seconds);
//        Reporter.log(getCurrentClassName() + " Found the element " + mobileElement.toString() + " to be clickable for " + seconds + " seconds", true);
    }

    public MobileElement waitForElementToBeClickable(MobileElement element, int waitInSeconds) {
        new WebDriverWait(appiumDriver, waitInSeconds).until(ExpectedConditions.elementToBeClickable(element));
//        Reporter.log(getCurrentClassName() + " Element is found to be clickable " + element.toString(), true);
        return element;
    }

    public void scrollDown(WebDriver appiumDriver){
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        sleep(2000);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForElementToLoad() {
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void click(MobileElement mobileElement){
        mobileElement.click();
//        Reporter.log(getCurrentClassName() + " Click on element " + mobileElement.toString(), true);
    }

    public void clear(MobileElement mobileElement){
        mobileElement.clear();
//        Reporter.log(getCurrentClassName() + " Clear element " + mobileElement.toString(), true);
    }

    public void sendKeys(MobileElement mobileElement, String sendKeysText){
        mobileElement.sendKeys(sendKeysText);
//        Reporter.log(getCurrentClassName() + " SendKeys to an element " + mobileElement.toString(), true);
    }

    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT;
    }


    public static void swipe(AppiumDriver<MobileElement> driver, DIRECTION direction, float startXOrY, float endXOrY, long duration) {
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;
        Dimension size = driver.manage().window().getSize();
        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * startXOrY);
                endX = (int) (size.width * endXOrY);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;
            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * startXOrY);
                endX = (int) (size.width * endXOrY);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;
            case UP:
                endY = (int) (size.height * endXOrY);
                startY = (int) (size.height * startXOrY);
                startX = size.width / 2;
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;
            case DOWN:
                startY = (int) (size.height * startXOrY);
                endY = (int) (size.height * endXOrY);
                startX = size.width / 2;
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;
        }
    }

    public static void swipeLeft(AppiumDriver<MobileElement> driver, MobileElement element) {
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
//        int endX = startX - 800; // Adjust the value as per your requirement
        int endX = startX - 500;
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.point(startX, startY))
                .moveTo(ElementOption.point(endX, startY))
                .release()
                .perform();
    }


    public static void swipeRight(AppiumDriver<MobileElement> driver, MobileElement element) {
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int endX = startX + 100; // Adjust the value as per your requirement

        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(element, startX, startY))
                .moveTo(ElementOption.element(element, endX, startY))
                .release()
                .perform();
    }

    public boolean isElementVisible(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    //Android specific utilities

    public MobileElement scrollToAnElementByText(String text) {
        return appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    public void scrollByText(String text) {
        appiumDriver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + text + "\").instance(0))"));
    }
}