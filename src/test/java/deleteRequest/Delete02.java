package deleteRequest;

import baseURLs.DummyRestApiExampleBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiExampleBaseURL {

         /*
    Given
            1)https://dummy.restapiexample.com/api/v1/delete/2

        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 200 olduğunu
		 And
		    Response body in

		    {
    "status": "success",
    "data": "719",
    "message": "Successfully! Record has been deleted"
}

     */


    @Test
    public void delete01(){

        specification.pathParams("p1","delete","p2","823");


        //Set Expected Data
        DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();
        HashMap<String,String> expectedDataMap = dummyRestApiTestData.setExpectedDataForDelete("success","823","Successfully! Record has been deleted");

        Response response = given().spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/{p1}/{p2}");

        response.prettyPrint();

      /*  response.then().assertThat().
                statusCode(200)
                .body("status",equalTo("success"),
                "data",equalTo("823"),"message",
                        equalTo("Successfully! Record has been deleted"));*/


        //Step4: Assertion

        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedDataMap.get("status"),jsonPath.getString("status"));
        assertEquals(expectedDataMap.get("data"),jsonPath.getString("data"));
        assertEquals(expectedDataMap.get("message"),jsonPath.getString("message"));




    }






}
