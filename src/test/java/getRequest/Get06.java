package getRequest;

import baseURLs.GorestCoInBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends GorestCoInBaseURL {

    /*
        Given
            https://gorest.co.in/public/v2/todos/14091
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
"id": 14071,
"user_id": 592752,
"title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
"due_on": "2023-03-20T00:00:00.000+05:30",
"status": "pending"
}
 */

    @Test
    public void get06() {

        //step 1: send request

        specification.pathParams("todosPath", "todos",
                        "idPath", "14071").
                queryParam("Token", "acc2b30a10f5a956fcd4192b37eaf01f904b7172a60005572472acee5c401266");

        Response response = given().spec(specification).
                when().get("/{todosPath}/{idPath}");

        response.prettyPrint();

        //1.doğrulama yolu

        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("id",equalTo(14071)).
                body("user_id",equalTo(592752)).
                body("title",equalTo("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.")).
                body("due_on",equalTo("2023-03-20T00:00:00.000+05:30")).
                body("status",equalTo("pending"));


        //2. way JsonPath bir classtır ve Json objeler içerisinde navigate etmemize olanak sağlar

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(14071,jsonPath.getInt("id"));
        Assert.assertEquals(592752,jsonPath.getInt("user_id"));
        Assert.assertEquals("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",jsonPath.getString("title"));
        Assert.assertEquals("2023-03-20T00:00:00.000+05:30",jsonPath.getString("due_on"));
        Assert.assertEquals("pending",jsonPath.getString("status"));






    }




}
