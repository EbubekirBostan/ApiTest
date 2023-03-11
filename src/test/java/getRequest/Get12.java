package getRequest;

import baseURLs.GorestCoInBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get12 extends GorestCoInBaseURL {

     /*


        Given
            https://gorest.co.in/public/v2/users/702440
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
    public void get12(){

        specification.pathParams("p1","users","p2","724776");

        //Step 2: set expected data


        String expectedData = "{\n" +
                "        \"id\": 724776,\n" +
                "        \"name\": \"Divakar Guha\",\n" +
                "        \"email\": \"guha_divakar@witting.co\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";


        //Object Mapper
        /*
        Obje Mapper ı kullanabilmek için
        maven projelerinde pom.xml
        dependecy eklemem gerekiyor. ---->maven repo
        <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-mapper-asl</artifactId>
            <version>1.9.13</version>
        </dependency>
         */

        System.out.println("expectedData = " + expectedData);

        GoRestCoApiPojo goRestCoApiPojo = JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPojo.class);

        System.out.println("goRestCoApiPojo = " + goRestCoApiPojo);

        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        System.out.println("expectedDataMap = " + expectedDataMap);

        Response response = given().spec(specification).when().get("/{p1}/{p2}");

        HashMap<String,Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);

        for (String key: expectedDataMap.keySet()){

            Assert.assertEquals(expectedDataMap.get(key),actualDataMap.get(key));
        }


    }




}
