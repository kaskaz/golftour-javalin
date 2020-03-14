package dev.kaskaz.golftour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppProperties.class);

    private static final String PROPS_FILE = "application.properties";

    private static Properties properties;

    private AppProperties () {}

    public static Properties getProperties() throws Exception {
        if (properties == null)
            init();
        return properties;
    }

    private static void init() throws Exception {
        if (properties == null) {
            synchronized (AppProperties.class) {
                if (properties == null) {
                    try(InputStream is = AppProperties.class.getClassLoader().getResourceAsStream(PROPS_FILE)) {
                        if (is == null)
                            throw new FileNotFoundException("application.properties file not found.");

                        properties = new Properties();
                        properties.load(is);
                    } catch (IOException e) {
                        LOGGER.error("Failed to initialize properties", e);
                        throw new Exception();
                    }
                }
            }
        }
    }

}
