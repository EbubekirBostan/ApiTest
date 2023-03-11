package getRequest;

import baseURLs.DummyRestApiExampleBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyRestApiTestData;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HomeWork07 extends DummyRestApiExampleBaseURL {

       /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */

    @Test
    public void homeWork07(){

        specification.pathParam("p1","create");

        String requestBody = "{\n" +
                "  \"name\": \"Drake F.\",\n" +
                "  \"salary\": \"40000\",\n" +
                "  \"age\": \"27\"\n" +
                "}";


        DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();

        List<Map<String,Object>> expectedMap = dummyRestApiTestData.bodyExpectedData("Successfully! Record has been added.","success","data","Drake F.","40000","27",7314);

        System.out.println("expectedMap = " + expectedMap);

        HashMap<String,Object> requestbodyMap = JsonToJava.convertJsonToJavaObject(requestBody,HashMap.class);

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(requestBody).when().
                post("/{p1}");

        response.prettyPrint();

        HashMap<String,Object> actualbodyMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);

        System.out.println("actualbodyMap = " + actualbodyMap);

        HashMap<String,Object> actualbodydataMap = JsonToJava.convertJsonToJavaObject(response.body().asString(), HashMap.class);
        System.out.println("actualbodydataMap = " + actualbodydataMap);



       // Assert.assertEquals(expectedMap.get(0).get("data"),actualbodyMap.get("data")); //Burada Durmadan id değişiyor hocam ???
            Assert.assertEquals(expectedMap.get(0).get("message"),actualbodyMap.get("message"));
            Assert.assertEquals(expectedMap.get(0).get("status"),actualbodyMap.get("status"));







    }






}
