import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_POST {


    @Test
    public void test_01_POST(){
        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("name", "Huda");
//        map.put("job", "SDET");

        System.out.println(map);

        JSONObject request = new JSONObject();

//        request.put("name", "Huda");
//        request.put("job", "SDET");
        String Req = "{\"paymentID\":\"ecdeb3a7-6559-40d2-a90a-4098c092af4c\",\"salesorderID\":\"bd3cc449-8789-4f62-8be7-86bf744c30bf\",\"SalesOrderDetailPromoID\":\"\"}";

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(Req).
                when().
                    post("http://virtual-idm-beta-uat-api.klikindomaret.net/api/Transaction/SellerUpdateFee").
                then().
                    statusCode(HttpStatus.SC_OK).
                    log().all();
    }

    @Test
    public void test_02_PUT(){

        JSONObject request = new JSONObject();

        request.put("name", "Huda");
        request.put("job", "TEST");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_02_PATCH(){

        JSONObject request = new JSONObject();

        request.put("name", "Huda");
        request.put("job", "TEST");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_04_DELETE(){
                when().
                    delete("https://reqres.in/api/users/2").
                then().
                    statusCode(204).
                    log().all();
    }
}
