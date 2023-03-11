package getRequest;

import baseURLs.DummyRestApiExampleBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get07 extends DummyRestApiExampleBaseURL {

       /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And



     */


    @Test

    public void get07(){

        specification.pathParam("employeesPath","employees");

        Response response = given().
                spec(specification).
                when().
                get("/{employeesPath}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath = response.jsonPath();

        List<Integer> employeAge= jsonPath.getList("data.employee_age");

        System.out.println("employeAge = " + employeAge);

        int count = 0;

        for (Integer w:employeAge) {

            if (w>55){
                count++;
            }
        }

        Assert.assertEquals(8,count);


        List<Integer> idS = jsonPath.getList("data.findAll{it.id>17}.id");

        System.out.println("idS = " + idS);

        Assert.assertEquals(7,idS.size());

       List<String> name = jsonPath.
                getList("data.findAll{it.employee_salary<100000}.employee_name");

        System.out.println("employee_name = " + name);

        Assert.assertTrue(name.contains("Doris Wilder"));




    }






}
