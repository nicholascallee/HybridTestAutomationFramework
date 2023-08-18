package nicholas.allee.test.automation.framework.utilities;

import java.io.*;
import java.util.Properties;

public class CustomParams {
    public String username;
    public String password;
    public CustomParams(String filename) throws IOException {
        Properties props = new Properties();
        InputStream input = CustomParams.class.getClassLoader().getResourceAsStream(filename);
        props.load(input);
        username = props.getProperty("orange.username");
        password = props.getProperty("orange.password");
    }
}
