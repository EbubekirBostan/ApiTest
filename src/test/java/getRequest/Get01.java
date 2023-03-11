package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.StatusLine;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


    /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */


    @Test
    public void get01(){

        /*
        4 tane adımda testlerimiz tanımlıyoruz

        1) URL tanımlamak lazım
        2)Expected data ları tanımlamak,set etmek lazım
        expected datalar test case den , doc. dan alınır(şuan için bu step ignore edilecektir)

        3) Request gönderme

        4)assertion işlemi

         */

        //step 1: url set et

        String URL = "https://restful-booker.herokuapp.com/booking/7";

        //step 2:expected dataları set et ignore edildi

        //step 3: Request Gönder

        Response response =
                given().
                when().get(URL);

        System.out.println("RESPONSE: ");
        response.prettyPrint();

        // STEP 4: aSSERTİON İŞLEMLERİ

        /*
        Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
         */

        //test 1:
        response.then().assertThat().statusCode(200);

        //test 2:
        response.then().assertThat().contentType("application/json");

        response.then().assertThat().contentType(ContentType.JSON);

        //test 3:

        response.then().assertThat().statusLine("HTTP/1.1 200 OK");


        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.getHeaders() = " + response.getHeaders());

        System.out.println("response.getStatusLine() = " + response.getStatusLine());

        System.out.println("response.getTime() = " + response.getTime());


    }




}
