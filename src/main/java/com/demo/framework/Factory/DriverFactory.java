package com.demo.framework.Factory;


import com.demo.framework.Utils.ProjectUtils;
import com.demo.framework.Utils.ConfigReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static com.demo.framework.Utils.ConfigReader.getPropValues;

public class DriverFactory {

    ProjectUtils projectUtils = new ProjectUtils();
    String currentWorkingDir = projectUtils.currentWorkingDir();

    public WebDriver driver;
    String newapp = "";
    public String USER = "";
    public String KEY = "";
    public String url = "";
    public String platform = "";
    public String deviceName = "";
    public String OSversion = "";
    public String UDIDAndroid = "";
    String filePath ="";
    String build = "";


    public void readProps(){
        getPropValues();
        USER= ConfigReader.USERNAME;
        KEY = ConfigReader.AUTOMATE_KEY;
        url = "https://" + USER + ":" + KEY + "@hub-cloud.browserstack.com/wd/hub";
        platform = ConfigReader.PlatformName;
        deviceName= ConfigReader.deviceName;
        OSversion = ConfigReader.osVersion;
        UDIDAndroid = ConfigReader.udidAndroid;
        if(platform.equalsIgnoreCase("IOS")){
            build = "IOS";
        }
        else if(platform.equalsIgnoreCase("Android")){
            build = "Android";
        }
    }

    public WebDriver createDriverInstance() {

//    	 AppiumDriver<MobileElement> driver = null;
        readProps();
//        newapp= getappUrlfromjson();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("interactiveDebugging", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);
//            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("os_version", OSversion);
        System.out.println(OSversion + "is the osversion");
        capabilities.setCapability("project", "MobileAutomation");
        capabilities.setCapability("build", build);
        capabilities.setCapability("name", "IOS");
        if(platform.equalsIgnoreCase("Android")) {
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("app", UDIDAndroid);
        }
        else {
        newapp= getappUrlfromjson();
        capabilities.setCapability("app", newapp);
        }

        if(platform.equalsIgnoreCase("IOS")) {
            try {
                driver = new IOSDriver<MobileElement>(new URL(url), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if(platform.equalsIgnoreCase("Android")) {
            try {
                driver = new AndroidDriver<MobileElement>(new URL(url), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return driver;
    }


    private String getappUrlfromjson(){

        if(platform.equalsIgnoreCase("IOS")) {
            filePath = currentWorkingDir + "/src/test/resources/response.json";
        }
//        else if(platform.equalsIgnoreCase("Android")){
//            filePath = currentWorkingDir + "/src/test/resources/responseAndroid.json";
//        }
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Parse the JSON string into a JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);
            // Extract the value based on the desired key
            newapp = jsonObject.getString("app_url");
            // Print the extracted value
            System.out.println("app_url from json-app" + newapp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newapp;
    }
}
