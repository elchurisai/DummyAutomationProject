package com.prolian.test.framework.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Props {

    private static final Logger  LOG =   LoggerFactory.getLogger(Props.class);
    private static Properties environmentProps;
    private static Properties properties;
    private static Properties messages;

    static {

        loadRunConfigProps("/environment.properties");
    }


    public static String getProp(String key) {

        if ((key==null) || key.isEmpty()) {
        return "";
        }
        else {
            return properties.getProperty(key);
        }
        }

    public static void loadRunConfigProps(String configPropertyFileLocation){

        environmentProps =new Properties();
        try (InputStream inputStream =Props.class.getResourceAsStream(configPropertyFileLocation)) {
            InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
            environmentProps.load(reader);
        }  catch (IOException e) {
            LOG.error(e.getMessage());
        }
        properties = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(environmentProps.getProperty("profile.path")))
        {
            InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
            properties.load(reader);
        }
        catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }


    public  static Properties getEnvironmentProps() {

        return environmentProps;
    }

}
