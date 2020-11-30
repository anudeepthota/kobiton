package com.kobiton.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configs {

    static String USERNAME = "anudeepthota";
    static String ACCESS_KEY = "2ff8bf33-6193-4618-a0fb-3113c5146b21";
    public static final URL kobitonServerUrl(){
        try {
            return new URL("https://" + USERNAME + ":" + ACCESS_KEY + "@api.kobiton.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generateBasicAuth(String username, String apiKey) {
        String authString = username + ":" + apiKey;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        return "Basic " + authStringEnc;
    }
    
    public static DesiredCapabilities desiredCapabilitiesAndroidWeb(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "Android Test Session");
        capabilities.setCapability("sessionDescription", "This is an example for Android Web testing");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("groupId", 297);
        capabilities.setCapability("deviceGroup", "KOBITON");
        capabilities.setCapability("deviceName", "Galaxy A50");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformName", "Android");
        return capabilities;
    }

    public static DesiredCapabilities desiredCapabilitiesAndroidApp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "Android app");
        capabilities.setCapability("sessionDescription", "This is an example for Android app testing");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("groupId", 297);
        capabilities.setCapability("app", "https://s3-ap-southeast-1.amazonaws.com/kobiton-devvn/apps-test/demo/com.dozuki.ifixit.apk");
        capabilities.setCapability("deviceGroup", "KOBITON");
        capabilities.setCapability("deviceName", "Galaxy S9+");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformName", "Android");
        return capabilities;
    }

    public static DesiredCapabilities desiredCapabilitiesiOSWeb(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "iOS Web");
        capabilities.setCapability("sessionDescription", "This is an example for iOS Web testing");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("browserName", "safari");
        capabilities.setCapability("groupId", 297);
        capabilities.setCapability("deviceGroup", "KOBITON");
        capabilities.setCapability("deviceName", "iPhone XS Max");
        capabilities.setCapability("platformVersion", "14.1");
        capabilities.setCapability("platformName", "iOS");
        return capabilities;
    }

    public static DesiredCapabilities desiredCapabilitiesiOSApp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "iOS app");
        capabilities.setCapability("sessionDescription", "This is an example for iOS App testing");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("groupId", 297);
        capabilities.setCapability("app", "https://s3-ap-southeast-1.amazonaws.com/kobiton-devvn/apps-test/demo/iFixit.ipa");
        capabilities.setCapability("deviceGroup", "KOBITON");
        capabilities.setCapability("deviceName", "iPhone 11 Pro Max");
        capabilities.setCapability("platformVersion", "13.6.1");
        capabilities.setCapability("platformName", "iOS");
        return capabilities;
    }
}
