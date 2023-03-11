package deleteRequest;

import baseURLs.RestfulBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete01 extends RestfulBookerHerokuappBaseUrl {


    /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */


    /*
    Post ile bookinge post ettiğimiz zaman delete edebiliriz
    {
    delete_boookingId[1,3,5,8] yazarak gibi
    }
     */


    @Test
    public void delete01(){

        specification.pathParams("p1","booking","p2","753");

        Response response = given().spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                when().
                delete("/{p1}/{p2}");

        response.prettyPrint();

        Assert.assertEquals(201,response.statusCode());

        Assert.assertTrue(response.body().asString().contains("Created"));

    }









}
