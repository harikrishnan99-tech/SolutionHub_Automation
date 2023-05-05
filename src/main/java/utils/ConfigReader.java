package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }

}

