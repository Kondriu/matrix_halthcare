package org.ge_halthcare.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() throws IOException {
        String pathToResources = "src/main/resources/main.properties";
        properties = new Properties();
        properties.load(new FileInputStream(pathToResources));
    }
    public static PropertiesReader getPropertiesReader() {
        PropertiesReader propertiesReader;
        {
            try {
                propertiesReader = new PropertiesReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return propertiesReader;
    }


    public String getValue(final String key) {
        return properties.getProperty(key);
    }
}
