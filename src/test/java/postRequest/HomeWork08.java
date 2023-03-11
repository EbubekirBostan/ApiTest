package postRequest;

import baseURLs.RestfulBookerHerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.BookingDatesPojo;
import pojoDatas.BookingPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HomeWork08 extends RestfulBookerHerokuappBaseUrl {

     /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */

    @Test
    public void post08(){

        specification.pathParam("p1","booking");


        BookingDatesPojo bookingDatesPojo =
                new BookingDatesPojo("2022-09-05","2023-06-01");

        BookingPojo reqBookingPojo =
                new BookingPojo("Drake","F.",4000,true,bookingDatesPojo, "Full Stack Test Automation Course with API and Appium");


        Response response = given().spec(specification).contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                body(reqBookingPojo).when().post("/{p1}");

        System.out.println("RESPONSE ");
        response.prettyPrint();



        JsonPath actualData = response.jsonPath();
        /*BookingPojo actualData1 = JsonToJava.convertJsonToJavaObject(response.asString(),BookingPojo.class);
        System.out.println("actualData1 = " + actualData1);*/

        System.out.println("actualData = " + actualData.prettyPrint());

        //Assertion

        Assert.assertEquals(reqBookingPojo.getFirstname(),actualData.getString("booking.firstname"));
        Assert.assertEquals(reqBookingPojo.getLastname(),actualData.getString("booking.lastname"));
        Assert.assertEquals(reqBookingPojo.getTotalprice(),Integer.parseInt(actualData.getString("booking.totalprice")));
        Assert.assertEquals(reqBookingPojo.getBookingdates().getCheckin(),actualData.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(reqBookingPojo.getBookingdates().getCheckout(),actualData.getString("booking.bookingdates.checkout"));
        Assert.assertEquals(reqBookingPojo.getAdditionalneeds(),actualData.getString("booking.additionalneeds"));

     /*   Assert.assertEquals(reqBookingPojo.getFirstname(),actualData1.getFirstname());
        Assert.assertEquals(reqBookingPojo.getLastname(),actualData1.getLastname());
        Assert.assertEquals(reqBookingPojo.getTotalprice(),actualData1.getTotalprice());
        Assert.assertEquals(reqBookingPojo.getBookingdates().getCheckin(),actualData1.getBookingdates().getCheckin());
        Assert.assertEquals(reqBookingPojo.getBookingdates().getCheckout(),actualData1.getBookingdates().getCheckout());
        Assert.assertEquals(reqBookingPojo.getAdditionalneeds(),actualData1.getAdditionalneeds());*/


    }





}
