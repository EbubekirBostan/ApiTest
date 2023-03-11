package testData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public HashMap<String,Object> expectedDatajson;


    public HashMap<String,Object> setUpDataTodos(){

        expectedDatajson = new HashMap<>();

        expectedDatajson.put("Server","cloudflare");
        expectedDatajson.put("StatusCode",200);
        expectedDatajson.put("userId",1);
        expectedDatajson.put("id",2.0);
        expectedDatajson.put("title","quis ut nam facilis et officia qui");
        expectedDatajson.put("completed",false);
        return expectedDatajson;


    }

    public HashMap<String,Object> setUpDataJson(){

        /*
           "userId": 10,
                                       "id": 198,
                                       "title": "quis eius est sint explicabo",
                                       "completed": true
         */


        expectedDatajson = new HashMap<>();


        expectedDatajson.put("userId",10);
        expectedDatajson.put("id",198);
        expectedDatajson.put("title","quis eius est sint explicabo");
        expectedDatajson.put("completed",true);
        return expectedDatajson;


    }
    public HashMap<String,Object> setUpForPutReq(){

        /*
            {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
         */


        expectedDatajson = new HashMap<>();


        expectedDatajson.put("userId",01);
        expectedDatajson.put("title","CW FSQA API Tutorial");
        expectedDatajson.put("completed",true);
        return expectedDatajson;


    }





}
