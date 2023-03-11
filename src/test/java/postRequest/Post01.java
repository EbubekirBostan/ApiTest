package postRequest;

import baseURLs.GorestCoInBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;

public class Post01 extends GorestCoInBaseURL {

    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */

    @Test
    public void post01(){

        specification.pathParams("p1","users");

        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();

        System.out.println("goRestApiTestData = " + goRestApiTestData.statusCodeDorPostInvalid());

        Response response = given().spec(specification).when().
                header("Authorization","Bearer 1cb525a1f43668d996e0dccc0e336a4d31e5ff5e594c9e21ddccc9b15a6d2914").post("/{p1}");

        response.prettyPrint();

        Assert.assertEquals(goRestApiTestData.statusCodeDorPostInvalid(),response.statusCode());


    }




}
