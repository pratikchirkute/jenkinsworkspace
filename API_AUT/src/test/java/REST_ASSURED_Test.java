import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class REST_ASSURED_Test extends baseClass{

    @Test
    public void getAPI() throws IOException {
        String url = getProperty("base.url")+"/entries";
        Response response = RestAssured
                .when()
                .get(url);

        System.out.println(response.getBody().print());
        Assert.assertTrue(response.getStatusCode()==200);
    }
}
