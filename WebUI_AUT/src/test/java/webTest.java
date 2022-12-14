import com.webFramework.Web;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class webTest extends Web {

    @Test
    public void sauceWebCheck() throws IOException {
        WebDriver driver = getDriver();
        driver.get(getProperty("base.url.saucedemo"));
        System.out.println(driver.getTitle());
        Assert.assertTrue("Swag Labs".matches(driver.getTitle()));
        driver.quit();
    }
}
