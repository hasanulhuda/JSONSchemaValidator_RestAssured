import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_GET {


    @Test
    public void test_01(){
        try {
            Thread.sleep(1);
            Response response = get("https://reqres.in/api/users?page=2");

            System.out.println("Status Code: "+response.getStatusCode());
            System.out.println("asString: "+response.asString());
            System.out.println("Body: "+response.getBody());
            System.out.println("StatusLine: "+ response.getStatusLine());
            System.out.println("coten-Type: "+response.getHeader("content-type"));
            System.out.println("Time: "+ response.getTime());

            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_02(){
        baseURI = "https://reqres.in";
        given()
             .get("/api/users?page=2")
        .then()
              .statusCode(200)
                .body("data.email[0]", equalTo(9));
    }
}
