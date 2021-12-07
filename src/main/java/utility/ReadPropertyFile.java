package utility;

import constants.FrameworkConstant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    static Properties property = new Properties();

    static {
        Path path = Paths.get(FrameworkConstant.getProjectBasePath(), "src", "test", "resources", "config", "config.properties");

        try (FileInputStream file = new FileInputStream(String.valueOf(path))) {
            property.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        String value = "";

        value = property.getProperty(key);
        if (Objects.isNull(value)) {
            try {
                throw new Exception("Property name key" + key + "not found in config.properties");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static void setProperty(String key, String value) {
        property.setProperty(key, value);
    }
}
