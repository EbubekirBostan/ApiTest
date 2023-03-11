package testData;

import java.util.HashMap;

public class GoRestApiTestData {

    public int statusCodeDorPostInvalid(){

        return 422;
    }

    public HashMap<String,String> reqBodyAndExpectedData(String name,String gender, String email, String status){

        HashMap<String,String> reqBodyAndExpectedDataMap = new HashMap<>();

        reqBodyAndExpectedDataMap.put("name",name);
        reqBodyAndExpectedDataMap.put("gender",gender);
        reqBodyAndExpectedDataMap.put("email",email);
        reqBodyAndExpectedDataMap.put("status",status);

        return reqBodyAndExpectedDataMap;



    }




}
