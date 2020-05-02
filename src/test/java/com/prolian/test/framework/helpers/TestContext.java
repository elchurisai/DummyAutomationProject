package com.prolian.test.framework.helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestContext {

    private static TestContext loader = new TestContext();
    private static final Logger LOG = LoggerFactory.getLogger(TestContext.class);
    private Properties properties;
    private Properties environmentProps;
    private String SELENIUM_PROTOCAL = System.getProperty("protocal");
    private String SELENIUM_HOST = System.getProperty("driverhost");
    private String SELENIUM_PORT = System.getProperty("driverport");
    private String PLATFORM;
    private String BROWSER = System.getProperty("browser",Props.getProp("browser"));
    private Integer BROWSER_WINDOW_WIDTH;
    private Integer BROWSER_WINDOW_HEIGHT;
    private Dimension BROWSER_WINDOW_SIZE;
    private String host = (StringUtils.isEmpty(System.getProperty("host"))? "www.selfridges.com": System.getProperty("host"));
    private String protocol = (StringUtils.isEmpty(System.getProperty("protocol"))? "https": System.getProperty("protocol"));
    private String scenarioName;
    private String device = System.getProperty("device");
    private List<String> tagNames = new ArrayList<>();
    private String baseURL;


    private TestContext() {

        loadSystemProperties(protocol,host,BROWSER,device);

    }

    public static TestContext getInstance() {

        return loader;
    }

    public String getSELENIUM_PROTOCAL() {
        return SELENIUM_PROTOCAL;
    }

    public void setSELENIUM_PROTOCAL(String SELENIUM_PROTOCAL) {
        this.SELENIUM_PROTOCAL = SELENIUM_PROTOCAL;
    }

    public String getSELENIUM_HOST() {
        return SELENIUM_HOST;
    }

    public void setSELENIUM_HOST(String SELENIUM_HOST) {
        this.SELENIUM_HOST = SELENIUM_HOST;
    }

    public String getSELENIUM_PORT() {
        return SELENIUM_PORT;
    }

    public void setSELENIUM_PORT(String SELENIUM_PORT) {
        this.SELENIUM_PORT = SELENIUM_PORT;
    }

    public String getPLATFORM() {
        return PLATFORM;
    }

    public void setPLATFORM(String PLATFORM) {
        this.PLATFORM = PLATFORM;
    }

    public String getBROWSER() {
        return BROWSER;
    }

    public void setBROWSER(String BROWSER) {
        this.BROWSER = BROWSER;
    }

    public Integer getBROWSER_WINDOW_WIDTH() {
        return BROWSER_WINDOW_WIDTH;
    }

    public void setBROWSER_WINDOW_WIDTH(Integer BROWSER_WINDOW_WIDTH) {
        this.BROWSER_WINDOW_WIDTH = BROWSER_WINDOW_WIDTH;
    }

    public Integer getBROWSER_WINDOW_HEIGHT() {
        return BROWSER_WINDOW_HEIGHT;
    }

    public void setBROWSER_WINDOW_HEIGHT(Integer BROWSER_WINDOW_HEIGHT) {
        this.BROWSER_WINDOW_HEIGHT = BROWSER_WINDOW_HEIGHT;
    }

    public Dimension getBROWSER_WINDOW_SIZE() {
        return BROWSER_WINDOW_SIZE;
    }

    public void setBROWSER_WINDOW_SIZE(Dimension BROWSER_WINDOW_SIZE) {
        this.BROWSER_WINDOW_SIZE = BROWSER_WINDOW_SIZE;
    }

    public String getHost() {
        return protocol + "://" + host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProtocal() {
        return protocol;
    }

    public void setProtocal(String protocal) {
        this.protocol = protocol;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public List<String> getTagNames() {
        return tagNames;
    }

    public void setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
    }

    public URL getBaseURL() {

        URL homeURL =null;

        try {
            homeURL = new URL(baseURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Home URL " +homeURL);
        return homeURL;
    }

    public void setBaseURL(String browserCountry) {


        this.baseURL = getHost() + "/" +browserCountry;
    }

    // Load the system properties
    private void loadSystemProperties(String protocal, String host,String browser,String device) {


    properties = new Properties();
    environmentProps = new Properties();

        try( InputStream inputStream= Props.class.getResourceAsStream("/environment.properties"))
         {
            InputStreamReader reader =new InputStreamReader(inputStream,"UTF-8");
            environmentProps.load(reader);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
             try( InputStream inputStream =  Props.class.getResourceAsStream(environmentProps.getProperty("profile.path")))
             {
             InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
             properties.load(reader);
             }  catch (IOException e)
             {
                LOG.error(e.getMessage());
    }

    setBROWSER_WINDOW_HEIGHT();
    setBROWSER_WINDOW_SIZE();
    setBROWSER_WINDOW_WIDTH();

    if (StringUtils.isEmpty(protocal)) {

        setProtocal();
    }

    if (StringUtils.isEmpty(host)) {
        setHost();
    }

    if (StringUtils.isEmpty(browser)) {

        setBrowserType();
    }

    if (StringUtils.isEmpty(device)){
        setDevice();
    }

    }

    private void setDevice() {
        device = "DESKTOP";
    }

    /// Define the missing parameters


    private void setBrowserType() {
    }

    private void setHost() {

        host=getProperty("host");
    }

    public String getProperty(String key) {

        return properties.getProperty(key);
    }

    private void setProtocal() {
        protocol ="https";

    }

    private void setBROWSER_WINDOW_WIDTH() {
    }

    private void setBROWSER_WINDOW_SIZE() {
    }

    private void setBROWSER_WINDOW_HEIGHT() {


    }


    public String getDevice() {
        return device;
    }

}
