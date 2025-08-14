package core;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigReader {
    private static final Map<String, Properties> configCache = new ConcurrentHashMap<>();

    private ConfigReader() {
    }

    public static String getProperty(String fileName, String key) {
        if (!configCache.containsKey(fileName)) {
            loadProperties(fileName);
        }

        Properties properties = configCache.get(fileName);
        String value = properties.getProperty(key);

        if (Objects.isNull(value)) {
            throw new RuntimeException("Property '" + key + "' not found in '" + fileName + "'.");
        }
        return value;
    }

    private static void loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (Objects.isNull(input)) {
                throw new RuntimeException("Unable to find " + fileName + " in the classpath.");
            }
            properties.load(input);
            configCache.put(fileName, properties);
        } catch (Exception e) {
            throw new RuntimeException("Error loading " + fileName + ": " + e.getMessage(), e);
        }
    }
}
