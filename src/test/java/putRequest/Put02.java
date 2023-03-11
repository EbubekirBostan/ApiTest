package putRequest;

import baseURLs.RestfulBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.BookingDatesPojo;
import pojoDatas.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends RestfulBookerHerokuappBaseUrl {


       /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/37
	        2) {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> token=001832eb39ba0ca
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */

    //"token": "062999ff34c2b5f"



    @Test
    public void put02(){

        specification.pathParams("p1","booking","p2","37");


        BookingDatesPojo bookingDatesPojo =
                new BookingDatesPojo("2022-01-01","2023-01-01");

        BookingPojo reqBookingPojo =
                new BookingPojo("Drake","F.",4000,true,bookingDatesPojo, "API and Appium");


        Response response = given().spec(specification).contentType(ContentType.JSON).
                header("Cookie","token="+"2a793c39665a7e0").
                body(reqBookingPojo).when().put("/{p1}/{p2}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getString("firstname"),reqBookingPojo.getFirstname());
        assertEquals(jsonPath.getString("lastname"),reqBookingPojo.getLastname());
        assertEquals(jsonPath.getInt("totalprice"),reqBookingPojo.getTotalprice());
        assertEquals(jsonPath.getBoolean("depositpaid"),reqBookingPojo.isDepositpaid());
        assertEquals(jsonPath.getString("bookingdates.checkin"),bookingDatesPojo.getCheckin());
        assertEquals(jsonPath.getString("bookingdates.checkout"),bookingDatesPojo.getCheckout());
        assertEquals(jsonPath.getString("additionalneeds"),reqBookingPojo.getAdditionalneeds());





    }

}
