package testData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TmdbApiTestData {

    private String apiKey = "2a97cfea997b3ded55a6fd8a61b3fc88";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String formatted(String a){

        String b = String.format("{%s}",a);

        return b;

    }

    public Response get(RequestSpecification specification,Response response,String p1,String p2, String p3){

        return response = given().spec(specification).contentType(ContentType.JSON).when().get("/"+p1+"/"+p2+"/"+p3);

    }



}
