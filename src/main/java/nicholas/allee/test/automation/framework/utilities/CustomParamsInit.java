package nicholas.allee.test.automation.framework.utilities;

import java.io.IOException;

public class CustomParamsInit {
    CustomParams customParams = new CustomParams("testParameters.properties");

    public CustomParamsInit() throws IOException {
    }
}
