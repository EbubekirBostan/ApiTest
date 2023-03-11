package getRequest;

import baseURLs.SwapiDevBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class HomeWork4 extends SwapiDevBaseURL {

      /*

    Given
	   	     https://swapi.dev/api/vehicles/4
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
   {
    "name": "Sand Crawler",
    "model": "Digger Crawler",
    "manufacturer": "Corellia Mining Corporation",
    "cost_in_credits": "150000",
    "length": "36.8 ",
    "max_atmosphering_speed": "30",
    "crew": "46",
    "passengers": "30",
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "vehicle_class": "wheeled",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/5/"
    ],
    "created": "2014-12-10T15:36:25.724000Z",
    "edited": "2014-12-20T21:30:21.661000Z",
    "url": "https://swapi.dev/api/vehicles/4/"
}


     */


    @Test
    public void swapTest(){

        specification.
                pathParams("vehiclesPath","vehicles","idPath","4");

        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        String expectedData = "{\n" +
                "    \"name\": \"Sand Crawler\",\n" +
                "    \"model\": \"Digger Crawler\",\n" +
                "    \"manufacturer\": \"Corellia Mining Corporation\",\n" +
                "    \"cost_in_credits\": \"150000\",\n" +
                "    \"length\": \"36.8 \",\n" +
                "    \"max_atmosphering_speed\": \"30\",\n" +
                "    \"crew\": \"46\",\n" +
                "    \"passengers\": \"30\",\n" +
                "    \"cargo_capacity\": \"50000\",\n" +
                "    \"consumables\": \"2 months\",\n" +
                "    \"vehicle_class\": \"wheeled\",\n" +
                "    \"pilots\": [\n" +
                "        \n" +
                "    ],\n" +
                "    \"films\": [\n" +
                "        \"https://swapi.dev/api/films/1/\",\n" +
                "        \"https://swapi.dev/api/films/5/\"\n" +
                "    ],\n" +
                "    \"created\": \"2014-12-10T15:36:25.724000Z\",\n" +
                "    \"edited\": \"2014-12-20T21:30:21.661000Z\",\n" +
                "    \"url\": \"https://swapi.dev/api/vehicles/4/\"\n" +
                "}";

        String actualData = response.getBody().asString();

        Assert.assertEquals(expectedData,actualData);

        //JsonPath jsonPath = response.jsonPath().getString()
//
       // List<Object> body = jsonPath.getList(response.getBody().asString());
//
       // System.out.println("body = " + body);




    }





}
