package com.orderry.helper.system.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {
    public String getSelenideProperty(String key) throws IOException {
        return getProperty(key, "selenide.properties");
    }

    public String getAuthProperty(String key) throws IOException {
        return getProperty(key, "auth_test_data.properties");
    }

    public String getUrlProperty(String key) throws IOException {
        return getProperty(key, "url.properties");
    }

    private String getProperty(String key, String fileName) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();

        properties.load(new InputStreamReader(Objects.requireNonNull(
                        loader.getResourceAsStream(fileName)), StandardCharsets.UTF_8));
        return properties.getProperty(key);
    }
}
