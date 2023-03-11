package putRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonPlaceHolderBaseURL {

     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
     */


    @Test
    public void put01(){

        //step 1: set ur

        specification.pathParams("p1","todos","p2","198");

        //step 2: set ex and req body

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        Map<String,Object> expectedAndReqBodyMap = jsonPlaceHolderTestData.setUpForPutReq();

        System.out.println("expectedAndReqBodyMap = " + expectedAndReqBodyMap);

        //step 3:

        Response response = given().spec(specification).
                contentType(ContentType.JSON).
                body(expectedAndReqBodyMap).
                when().put("/{p1}/{p2}");

        response.prettyPrint();


        //step 4:

        Map<String,Object> actualDataAndBody = response.as(HashMap.class);

        System.out.println("actualDataAndBody = " + actualDataAndBody);

        Assert.assertEquals(200,response.statusCode());

        for (String key: actualDataAndBody.keySet()){
            Assert.assertEquals(expectedAndReqBodyMap.get(key),actualDataAndBody.get(key));
        }


    }




}
