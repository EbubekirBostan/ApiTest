package getRequest;

import baseURLs.GorestCoInBaseURL;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestCoInPojo;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


@JsonIgnoreProperties(ignoreUnknown = true)//uyuşmazlık olursa bu anotation çözüyor
public class Get13 extends GorestCoInBaseURL {


     /*
        Given
            https://gorest.co.in/public/v2/users/714224
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
{
        "id": 724776,
        "name": "Divakar Guha",
        "email": "guha_divakar@witting.co",
        "gender": "male",
        "status": "active"
    }
*/

    @Test
    public void homeWork05(){

        specification.pathParams("p1","users","p2","724776");


        GorestCoInPojo expectedData =
                new GorestCoInPojo(724776,"Divakar Guha","guha_divakar@witting.co","male","active");

        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(specification).when().get("/{p1}/{p2}");

        System.out.println("Response");

        response.prettyPrint();

        //Map<String,Object> actualData = response.as(HashMap.class);
        GorestCoInPojo actualData = response.as(GorestCoInPojo.class);

        System.out.println("actualData = " + actualData);

        response.then().assertThat().statusCode(200);

        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedData.getGender(),actualData.getGender());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());









    }






}
