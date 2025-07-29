package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataUtils {
    private static Properties testDataProperties;

    static {
        try {
            String filePath = "src/test/resources/testdata.properties";
            testDataProperties = new Properties();
            testDataProperties.load(new FileReader(filePath));
        } catch (IOException e) {
            System.err.println("Could not load test data properties file.");
            e.printStackTrace();
        }
    }

    public static String getTestData(String key) {
        return testDataProperties.getProperty(key);
    }
}
