package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseURL {

       /*
        Given
            https://jsonplaceholder.typicode.com/users
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.

     */

    @Test
    public void get04(){

        specification.pathParam("users","users");

        Response response = given().spec(specification).when().get("/{users}");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
        body("id",hasSize(10));

        response.prettyPrint();






    }




}
