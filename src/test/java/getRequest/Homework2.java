package getRequest;

import baseURLs.RestfulBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Homework2 extends RestfulBookerHerokuappBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/

    @Test
    public void restfullTest(){

        specification.pathParam("bookingPath","booking");

        specification.queryParam("firstname","Sarah");

        Response response = given().spec(specification).when().get("/{bookingPath}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

            JsonPath jsonPath = response.jsonPath();

            try {
                jsonPath.getInt("[0].bookingid");
                Assert.assertTrue(true);

            }catch (NullPointerException e){

                Assert.fail("Bookingid bulunamadı");

            }

    }

     /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/











}
