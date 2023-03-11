package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseURL {



    @Test
    public void get03(){

        //step 1: set url
        specification.pathParams("todosPath","todos",
                "idPath","2");
        //step 2: ignore

        //step 3: send request

        Response response = given().
                spec(specification).
                        when().
                        get("/{todosPath}/{idPath}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        response.
                then().
                assertThat().
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),
                        "userId",equalTo(1));






    }








}
