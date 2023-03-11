package getRequest;

import baseURLs.TheMovieDbBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

public class Get05 extends TheMovieDbBaseURL {

    /*
        Given
            https://api.themoviedb.org/3/movie/popular?

            apı_key = 2a97cfea997b3ded55a6fd8a61b3fc88
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */

    @Test
    public void get05() {

        //step 1: send request

        specification.pathParams("moviePath","movie",
                "popularPath","popular").
                queryParam("api_key","2a97cfea997b3ded55a6fd8a61b3fc88");
        //step 2: ignore

        //step 3: send request

        Response response = given().
                spec(specification).
                when().
                get("/{moviePath}/{popularPath}");

            response.prettyPrint();

            response.then().assertThat().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    body("results.id",hasItems(646389,536554,640146));


    }



}
