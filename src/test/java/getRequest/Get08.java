package getRequest;

import baseURLs.SwapiDevBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get08 extends SwapiDevBaseURL {


    @Test
    public void swapTest() {

        specification.
                pathParams("vehiclesPath", "vehicles", "idPath", "4");



        //step 2: Expected Data

        //Trick ----> Her zaman içeriden başla


        List<String> filmList = new ArrayList<>();
        filmList.add("https://swapi.dev/api/films/1/");
        filmList.add("https://swapi.dev/api/films/5/");

        List<String> pilotList = new ArrayList<>();
        System.out.println("pilotList = " + pilotList);

        Map<String,Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("name","Sand Crawler");
        expectedDataMap.put("model","Digger Crawler");
        expectedDataMap.put("manufacturer","Corellia Mining Corporation");
        expectedDataMap.put("cost_in_credits","150000");
        expectedDataMap.put("length","36.8 ");
        expectedDataMap.put("max_atmosphering_speed","30");
        expectedDataMap.put("crew","46");
        expectedDataMap.put("passengers","30");
        expectedDataMap.put("cargo_capacity","50000");
        expectedDataMap.put("consumables","2 months");
        expectedDataMap.put("vehicle_class","wheeled");
        expectedDataMap.put("pilots",pilotList);
        expectedDataMap.put("films",filmList);
        expectedDataMap.put("created","2014-12-10T15:36:25.724000Z");
        expectedDataMap.put("edited","2014-12-20T21:30:21.661000Z");
        expectedDataMap.put("url","https://swapi.dev/api/vehicles/4/");

        System.out.println("expectedDataMap = " + expectedDataMap);

        //step 3: Send Request

        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");

        System.out.println("Response: " );
        response.prettyPrint();

        // Step 4: Assertion operations
        response.then().assertThat().statusCode(200).
                body("name",equalTo(expectedDataMap.get("name")),
                        "model",equalTo(expectedDataMap.get("model")),
                        "manufacturer",equalTo(expectedDataMap.get("manufacturer")),
                        "length",equalTo(expectedDataMap.get("length")),
                        "max_atmosphering_speed",equalTo(expectedDataMap.get("max_atmosphering_speed")),
                        "crew",equalTo(expectedDataMap.get("crew")),
                        "cost_in_credits",equalTo(expectedDataMap.get("cost_in_credits")),
                        "passengers",equalTo(expectedDataMap.get("passengers")),
                        "cargo_capacity",equalTo(expectedDataMap.get("cargo_capacity")),
                        "consumables",equalTo(expectedDataMap.get("consumables")),
                        "vehicle_class",equalTo(expectedDataMap.get("vehicle_class")),
                        "films",equalTo(expectedDataMap.get("films")),
                        "pilots",equalTo(expectedDataMap.get("pilots")),
                        "created",equalTo(expectedDataMap.get("created")),
                        "edited",equalTo(expectedDataMap.get("edited")),
                        "url",equalTo(expectedDataMap.get("url")));


        //2. Way

        Map<String,Object> actualData = response.as(HashMap.class);

        System.out.println("actualData = " + actualData);

        /*
        GSON ----> Deserializaiton

        Deserializaiton -- Json objelerini Java objelerini convert etmek demektir


         */
        assertEquals(expectedDataMap.get("name"),actualData.get("name"));
        assertEquals(expectedDataMap.get("max_atmosphering_speed"),actualData.get("max_atmosphering_speed"));
        assertEquals(expectedDataMap.get("cargo_capacity"),actualData.get("cargo_capacity"));
        assertEquals(expectedDataMap.get("films"),actualData.get("films"));
        assertEquals(expectedDataMap.get("passengers"),actualData.get("passengers"));
        assertEquals(expectedDataMap.get("pilots"),actualData.get("pilots"));
        assertEquals(expectedDataMap.get("edited"),actualData.get("edited"));
        assertEquals(expectedDataMap.get("consumables"),actualData.get("consumables"));
        assertEquals(expectedDataMap.get("created"),actualData.get("created"));
        assertEquals(expectedDataMap.get("length"),actualData.get("length"));
        assertEquals(expectedDataMap.get("url"),actualData.get("url"));
        assertEquals(expectedDataMap.get("manufacturer"),actualData.get("manufacturer"));
        assertEquals(expectedDataMap.get("crew"),actualData.get("crew"));
        assertEquals(expectedDataMap.get("vehicle_class"),actualData.get("vehicle_class"));
        assertEquals(expectedDataMap.get("cost_in_credits"),actualData.get("cost_in_credits"));
        assertEquals(expectedDataMap.get("model"),actualData.get("model"));

        assertEquals(expectedDataMap,actualData);

        JsonPath actualJson = response.jsonPath();




        SoftAssert softAssert = new SoftAssert();

        for (Map.Entry<String,Object> map : actualData.entrySet()){

            softAssert.assertEquals(expectedDataMap.get(map.getKey()),actualData.get(map.getKey()));
        }
        softAssert.assertAll();

        System.out.println("yapıldııı");






    }



}
