package postRequest;

import baseURLs.DummyRestApiExampleBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiPojo;
import pojoDatas.DummyRestApiExPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends DummyRestApiExampleBaseURL {





    @Test
    public void post03() {

        specification.pathParam("p1", "create");

        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo("Droke F.","50000","29");


        DummyRestApiExPojo dummyRestApiExPojo =
                new DummyRestApiExPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");

        //Basic Auth. ---> öğrenme amaçlı yapacağız kullanacağız
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().basic("admin","password123").
                body(dummyRestApiPojo).
                when().
                post("/{p1}");
        response.prettyPrint();


        //Step 4: Assertion İşlemi:

        DummyRestApiExPojo actualData = response.as(DummyRestApiExPojo.class);
        System.out.println("Actual Data: " + actualData);

        assertEquals(dummyRestApiExPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyRestApiExPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyRestApiExPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyRestApiExPojo.getData().getName(),actualData.getData().getName());
        assertEquals(dummyRestApiExPojo.getData().getSalary(),actualData.getData().getSalary());











    }
}
