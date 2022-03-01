import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void test_02(){
        baseURI = "https://reqres.in";
        given()
                .get("/api/users?page=2")
                .then()
                    .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                    .statusCode(200);
//                    .body("data.email[0]", equalTo(9));
    }

}
