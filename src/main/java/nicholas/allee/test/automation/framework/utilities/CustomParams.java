package nicholas.allee.test.automation.framework.utilities;

import java.io.*;
import java.util.Properties;

public class CustomParams {
    public String username;
    public String password;
    public CustomParams() throws IOException {
        String currentEnvironment = System.getProperty("environment");
        String propertiesFileName = getProfile(currentEnvironment);
        Properties props = new Properties();
        InputStream input = CustomParams.class.getClassLoader().getResourceAsStream(propertiesFileName);
        props.load(input);
        username = props.getProperty("orange.username");
        password = System.getProperty("password");
    }

    public String getProfile(String environment){
        return switch (environment){
            case "dev" -> "devParameters.properties";
            case "test" -> "testParameters.properties";
            case "prod" -> "prodParameters.properties";
            default -> "null";
        };
    }
}
