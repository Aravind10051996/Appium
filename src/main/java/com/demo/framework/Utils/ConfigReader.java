package com.demo.framework.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String USERNAME = "";
    public static String AUTOMATE_KEY = "" ;
    public static String AppUSERNAME = "";
    public static String AppPassword = "";
    public static String AppEnvironment = "";
    public static String PlatformName=  "";
    public static String deviceName = "";
    public static String osVersion= "";
    public static String udidAndroid = "";

    public static void getPropValues(){
        Properties prop = new Properties();
        InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String usernameParamFromEnv = System.getProperty("bsUsername");
        USERNAME = usernameParamFromEnv == null ? prop.getProperty("bsUsername") : usernameParamFromEnv;
        String passwordParamFromEnv = System.getProperty("bsPassword");
        AUTOMATE_KEY = passwordParamFromEnv == null ? prop.getProperty("bsPassword") : passwordParamFromEnv;
        String appusernameParamFromEnv = System.getProperty("AppUserName");
        AppUSERNAME = appusernameParamFromEnv == null ? prop.getProperty("AppUserName") : appusernameParamFromEnv;
        String apppasswordParamFromEnv = System.getProperty("AppPassword");
        AppPassword = apppasswordParamFromEnv == null ? prop.getProperty("AppPassword") : apppasswordParamFromEnv;
        String appEnv = System.getProperty("AppEnvironment");
        AppEnvironment = appEnv == null ? prop.getProperty("AppEnvironment") : appEnv;
        String platform = System.getProperty("PlatformName");
        PlatformName = platform == null ? prop.getProperty("PlatformName") : platform;
        String devicename = System.getProperty("DeviceName");
        deviceName = devicename == null ? prop.getProperty("DeviceName") : devicename;
        String osversion = System.getProperty("OSversion");
        osVersion = osversion == null ? prop.getProperty("OSversion") : osversion;
        String udidandroid = System.getProperty("UDIDAndroid");
        udidAndroid = udidandroid == null ? prop.getProperty("UDIDAndroid") : udidandroid;


        System.out.println("username is:"+USERNAME);
        System.out.println("password is:"+AUTOMATE_KEY);
        System.out.println("Appusername is:"+AppUSERNAME);
        System.out.println("Apppassword is:"+AppPassword);
        System.out.println("AppEnvironemnt is:"+AppEnvironment);
        System.out.println("Platform is:"+PlatformName);
        System.out.println("Device name is:"+deviceName);
        System.out.println("OSVersion is:"+osVersion);
        System.out.println("UDIDAndroid is:"+udidAndroid);
    }


}
