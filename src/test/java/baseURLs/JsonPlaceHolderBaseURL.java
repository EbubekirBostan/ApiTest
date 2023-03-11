package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {

   protected RequestSpecification specification;

    @Before
    public void setupBaseURL(){

        //https://jsonplaceholder.typicode.com/todos/2

        specification = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();



    }




}
