package com.prolian.test.framework.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class WebDriverHelper extends EventFiringWebDriver {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverHelper.class);
    public static RemoteWebDriver REAL_DRIVER = null;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
        if (REAL_DRIVER!=null) {
            REAL_DRIVER.quit();
        }
    }
    };
    private static TestContext testContext = TestContext.getInstance();
    private static String BROWSER= testContext.getBROWSER();
    private static String SELENIUM_PROTOCOL =testContext.getSELENIUM_PROTOCAL();
    private static String SELENIUM_HOST = testContext.getSELENIUM_HOST();
    private static  String SELENIUM_PORT = testContext.getSELENIUM_PORT();
    public static String DEVICE = testContext.getDevice();

    private WebDriverHelper() {
        super(REAL_DRIVER);
    }
    static {

        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }


    public static WebDriver getWebDriver()
    {
        return  REAL_DRIVER;
    }

    public static WebDriver getSpecificWebDriver(String device) {

        if (DEVICE.equalsIgnoreCase("DESKTOP"))
        {
            if (null==REAL_DRIVER) {
                getDriverBasedonDevice(BROWSER, device);
            }
            REAL_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            REAL_DRIVER.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
            }
        return REAL_DRIVER;
    }


    private static void getDriverBasedonDevice(String browser,String mode) {

        switch (browser.toUpperCase()) {

            case "CHROME" :
                startChromeDriver(mode);
                break;
            case "FIREFOX" :
                startFireFoxDriver(mode);
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported" + System.getProperty("browserName"));
        }

        setBrowserWindowSize(REAL_DRIVER,mode);

    }

    private static void setBrowserWindowSize(WebDriver webDriver, String mode) {

        switch (mode.toUpperCase()) {

            case "DESKTOP" :
                REAL_DRIVER.manage().window().maximize();
                break;
        }


    }

    private static void startFireFoxDriver(String mode) {

        FirefoxOptions options = getFireFoxOptions() ;
        if (StringUtils.isEmpty(SELENIUM_HOST)) {
        LOG.info("Executing  Tests Locally on FireFox ");
        WebDriverManager.firefoxdriver().setup();
        REAL_DRIVER = new FirefoxDriver(options);
        }
        else {
            LOG.info("Code will be implemented later");
        }
    }

    private static FirefoxOptions getFireFoxOptions() {

        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("network.cookie.cookieBehavior",1);
        profile.setPreference("network.proxy.type",0);
        options.setCapability("platform","ANY");
        options.setCapability("acceptInsecureCerts",true);
        return options;
    }

    private static void startChromeDriver(String mode) {
        ChromeOptions options = getChromeOptions();
            if (StringUtils.isEmpty(SELENIUM_HOST)) {
                WebDriverManager.chromedriver().setup();
                REAL_DRIVER = new ChromeDriver(options);
            }
            else {
           //     REAL_DRIVER = getRemoteWebDriver(options);

            }

    }




    private static ChromeOptions getChromeOptions() {

        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.OFF);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("allow-running-insecure-content");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setCapability("acceptSslCerts",true);
        chromeOptions.setCapability("autoAcceptAlerts", "true");
        chromeOptions.setCapability("autoGrantPermissions", "true");

        return chromeOptions;
    }


}
