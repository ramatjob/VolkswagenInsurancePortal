package com.volkswagenfinance.utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;

public class TestBase {

    WebDriver driver=null;
    private String browserType = System.getProperty("browserType");
    private static String gridType = System.getProperty("gridType");
    private static String platformType = System.getProperty("platformType");
    private static String environmentType = System.getProperty("environmentType");
    private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());


    public WebDriver initializeDriver() {
        if(gridType.equalsIgnoreCase("Local")) {
            if (driver == null) {
                if (browserType.equalsIgnoreCase("Chrome")) {
                    driver = getChromeDriver();
                } else if (browserType.equalsIgnoreCase("Firefox")) {
                    //Firefox driver initialization code goes here
                }else if (browserType.equalsIgnoreCase("IE")) {
                    //IE driver initialization code goes here
                } else if (browserType.equalsIgnoreCase("Safari")) {
                    //Safari driver initialization code goes here
                }
            }
        }else if(gridType.equalsIgnoreCase("BrowserStack")){
            //BrowserStack driver initialization code goes here
        }else if(gridType.equalsIgnoreCase("SauceLabs")){
            //SauceLabs driver initialization code goes here
        } else if(gridType.equalsIgnoreCase("SeleniumGrid")){
            //SeleniumGrid driver initialization code goes here
        }
        return driver;
    }

    private WebDriver getChromeDriver() {
        LOGGER.info("Loading the Chrome driver");
        String driverPath = null;
        ChromeOptions chromeOptions = new ChromeOptions();

        if(platformType.equals((PlatformDetails.MAC).toString())) {
            driverPath = BrowserDriverDetails.chromeForMac.getProperty();
            chromeOptions.addArguments("--kiosk");
            chromeOptions.addArguments("--disable-notifications");
        }
        else if(platformType.equals((PlatformDetails.LINUX32).toString())) {
            driverPath = BrowserDriverDetails.chromeForLinux32.getProperty();
            chromeOptions.addArguments("--kiosk");
        }
        else if(platformType.equals((PlatformDetails.LINUX64).toString())) {
            driverPath = BrowserDriverDetails.chromeForLinux64.getProperty();
            chromeOptions.addArguments("--kiosk");
        }
        else if(platformType.equals((PlatformDetails.WIN32).toString())){
            driverPath = BrowserDriverDetails.chromeForWin32.getProperty();
            chromeOptions.addArguments("--start-maximized");
        }
        else if(platformType.equals((PlatformDetails.WIN64).toString())){
            driverPath = BrowserDriverDetails.chromeForWin64.getProperty();
            chromeOptions.addArguments("--start-maximized");
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver(chromeOptions);
    }

    public static String getUrl(String urlPath){
        String finalUrlPath = "";
        String finalURL = "";
        finalUrlPath = environmentType+"_url_"+urlPath;
        UrlDetails allUrls[] = UrlDetails.values();
        for (UrlDetails url : allUrls) {
            if(finalUrlPath.equalsIgnoreCase((url).toString())){
                finalURL = url.getProperty();
            }
        }
        return finalURL;
    }

    public void tearDown(){
        driver.close();
    }

}
