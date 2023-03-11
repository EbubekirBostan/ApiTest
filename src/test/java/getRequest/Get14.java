package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import testData.JsonPlaceHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get14 extends JsonPlaceHolderBaseURL {

    /*


       Given
           https://jsonplaceholder.typicode.com/todos/198
      When
           Kullanıcı GET Methodu ile Request Gönderir
       Then
            Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular

 {
                                       "userId": 10,
                                       "id": 198,
                                       "title": "quis eius est sint explicabo",
                                       "completed": true
                                     }

    */
    @Test
    public void get14(){
        specification.pathParams("todopath","todos","idpath","198");


        //step 2 :Expected Data
        String expectedData = "{\n" +
                "   \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "   \"completed\": true\n" +
                " }";

        HashMap<String,Object>expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData,HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);

        //Homework :Expected data yı JsonPlaceHolderTestData classında bir tane method create ederek yapınız.
        /*
        * JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

        String ex = jsonPlaceHolderBaseURL.createEdilen(userId); */

        //Step 3 : Send Rewuest
        Response response=given().
                spec(specification).
                when().
                get("/{todopath}/{idpath}");



        //step 4 :Assertion
        //actualData response 'dan alınır.

        //  HashMap<String,Object>actualDataMap =response.as(HashMap.class);//---> Gson
        //  JsonPath jsonPath=response.jsonPath();//--> json
        //  response.then().assertThat().body("");-->> response body
        //  HashMap<String,Object>actualDataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class); ---> object mapper


        HashMap<String,Object>actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);




        for (String key:actualDataMap.keySet()){

            Assert.assertEquals(expectedDataMap.get(key),actualDataMap.get(key));

        }

        //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

       //HashMap<String,Object> jsonMap = jsonPlaceHolderTestData.setUpDataJson();

        //System.out.println("jsonMap = " + jsonMap);

        for (String key:actualDataMap.keySet()){

            Assert.assertEquals(jsonPlaceHolderTestData.setUpDataJson().get(key),actualDataMap.get(key));

        }







    }
}