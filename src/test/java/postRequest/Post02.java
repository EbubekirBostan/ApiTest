package postRequest;

import baseURLs.GorestCoInBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import pojoDatas.GoRestPostApiPojo;
import testData.GoRestApiTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Post02  extends GorestCoInBaseURL {

        /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */
        @Test
        public void post01() {

            specification.pathParams("p1", "users");

            // step 2 set expected and request body


            GoRestApiTestData goRestApiTestData = new GoRestApiTestData();

            HashMap<String,String> reqBodyAndExpectedDataMap = goRestApiTestData.
                    reqBodyAndExpectedData("Ebekiir","male","ebekiir@ebb","active");






            Response response = given().
                    spec(specification).
                    contentType(ContentType.JSON).
                    body(reqBodyAndExpectedDataMap).
                    when().
                    header("Authorization","Bearer 1cb525a1f43668d996e0dccc0e336a4d31e5ff5e594c9e21ddccc9b15a6d2914").post("/{p1}");

            response.prettyPrint();


            GoRestPostApiPojo expectedBody = new  GoRestPostApiPojo("Ebekiir","ebekiir@ebb","male","active");

           // HashMap<String,Object> expectedBodyMap = JsonToJava.convertJsonToJavaObject(expectedBody.toString(), HashMap.class);

            HashMap<String,Object> actualBodyMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);


            Assert.assertEquals(expectedBody.getName(),actualBodyMap.get("name"));
            Assert.assertEquals(expectedBody.getEmail(),actualBodyMap.get("email"));
            Assert.assertEquals(expectedBody.getGender(),actualBodyMap.get("gender"));
            Assert.assertEquals(expectedBody.getStatus(),actualBodyMap.get("status"));













        }







}
