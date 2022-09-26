import com.webFramework.Web;
import org.testng.annotations.Test;

import java.io.IOException;

public class webTest extends Web {

    @Test
    public void sauceWebCheck() throws IOException {
        launchUrl(getProperty("base.url.saucedemo"));
        System.out.println("application launch");
        quitDriver();

    }
}
