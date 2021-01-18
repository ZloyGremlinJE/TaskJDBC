package jm.task.core.jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Util {
    private static final String CONFIG_NAME = "employee.properties";
    private static final Properties GLOBAL_CONFIG = new Properties();

    public static void initGlobalConfig() throws IOException {
        initGlobalConfig(null);
    }

    public static void initGlobalConfig(String name) throws IOException {
        if (name != null && !name.trim().isEmpty()) {
            GLOBAL_CONFIG.load(new FileReader(name));
        } else {
            GLOBAL_CONFIG.load(new FileReader(CONFIG_NAME));
        }
    }

    public static String getProperty(String property) {
        return GLOBAL_CONFIG.getProperty(property);
    }


}
