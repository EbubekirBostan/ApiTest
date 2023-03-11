package getRequest;

import baseURLs.DummyRestApiExampleBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get10 extends DummyRestApiExampleBaseURL {

    /*

    Given
	   	   https://dummy.restapiexample.com/api/v1/employees

		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular



     */


    @Test
    public void get10(){

        specification.pathParam("employeesPath","employees");

        DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();

        List<Map<String,Object>> expectedData = dummyRestApiTestData.setUpDummyRestTestData();



        System.out.println("expectedData = " + expectedData);


        Response response = given().spec(specification).when().get("/{employeesPath}");

        response.prettyPrint();

        response.then().assertThat().
                statusCode((Integer)expectedData.get(3).get("StatusCode")).
                body("data[-1].employee_name",equalTo(expectedData.get(0).get("EmployeeName")),
                        "data[5].employee_salary",equalTo(expectedData.get(2).get("EmployeeSalar")),
                        "data.employee_age",hasItems(((List)expectedData.get(1).get("EmployeeAges")).get(0)),
                        "data.employee_age",hasItems(((List)expectedData.get(1).get("EmployeeAges")).get(1)),
                        "data.employee_age",hasItems(((List)expectedData.get(1).get("EmployeeAges")).get(2)));




        List<Map<String,Object>> actualData = response.jsonPath().getList("data");

        System.out.print("actualData = " + actualData);

        Assert.assertEquals(expectedData.get(0).get("EmployeeName"),actualData.get(actualData.size()-1).get("employee_name"));
        Assert.assertEquals(expectedData.get(2).get("EmployeeSalar"),actualData.get(5).get("employee_salary"));

        List<Integer> ages = response.jsonPath().getList("data.findAll{(it.employee_age)>0}.employee_age");


        Assert.assertTrue(ages.containsAll((List<Integer>)  expectedData.get(1).get("EmployeeAges")));






    }




}
