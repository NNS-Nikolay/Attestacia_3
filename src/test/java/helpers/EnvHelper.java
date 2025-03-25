package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvHelper {

    public Properties getConfProperties() throws IOException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "env.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));

        return properties;

    }
}
