import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test_POST_SAS {

//    @DataProvider
    public Object[][] dataForPost(){
        Object[][] data = new Object[2][3];

        data[0][0] = "Albert";
        data[0][1] = "Einstein";
        data[0][2] = 2;

        data[1][0] = "Thomas";
        data[1][1] = "alpha";
        data[1][2] = 4;

        return data;
    }


//    @Test(dataProvider = "dataForPost")
    public void Test_POST(String firstName, String lastName, int subjectID){

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectID", subjectID);

//        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }

    @DataProvider(name ="DeleteData")
    public Object[] dataForDelete(){
        return  new Object[]{
                4,5,6,7
        };
    }

    @Test(dataProvider = "DeleteData")
    public void Test_Delete(int userId){
        baseURI = "http://localhost:3000/";
        System.out.println(baseURI);

        when().
                delete("/users/"+userId).
        then().
                statusCode(200);
    }

}
