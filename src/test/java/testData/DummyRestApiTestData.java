package testData;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiTestData {

    public List<Map<String,Object>> expectedDataList = new ArrayList<>();


    public List<Map<String,Object>> setUpDummyRestTestData(){

        HashMap<String,Object> expectedDataStatus = new HashMap<>();

        expectedDataStatus.put("StatusCode",200);

        HashMap<String,Object> expectedDataName = new HashMap<>();

        expectedDataName.put("EmployeeName","Doris Wilder");

        HashMap<String,Object> expectedDataSalary = new HashMap<>();

        expectedDataSalary.put("EmployeeSalar",372000);

        List<Integer> expectedDataAges = new ArrayList<>();

        expectedDataAges.add(21);
        expectedDataAges.add(23);
        expectedDataAges.add(59);

        HashMap<String,Object> expectedDataMapAges = new HashMap<>();

        expectedDataMapAges.put("EmployeeAges",expectedDataAges);

        expectedDataList.add(expectedDataName);
        expectedDataList.add(expectedDataMapAges);
        expectedDataList.add(expectedDataSalary);
        expectedDataList.add(expectedDataStatus);

        return expectedDataList;
    }

    /*
 {
"status": "success",
"data": {
    "name": "Drake F.",
    "salary": "40000",
    "age": "27",
    "id": 4545
},
 */
    public List<Map<String,Object>> bodyExpectedData(String message, String status,String data,String name,String salary, String age, int id){


        HashMap<String,Object> expectedDataName = new HashMap<>();
        expectedDataName.put("name",name);
        expectedDataName.put("salary",salary);
        expectedDataName.put("age",age);
        expectedDataName.put("id",id);
        HashMap<String,Object> bodyExpectedDataMap= new HashMap<>();
        bodyExpectedDataMap.put("status",status);
        bodyExpectedDataMap.put("message",message);
        bodyExpectedDataMap.put("data",expectedDataName);

        expectedDataList.add(bodyExpectedDataMap);





        return expectedDataList;
    };

    public HashMap<String,String> setExpectedDataForDelete(String status,String data,String message){

        HashMap<String,String> expectedData = new HashMap<>();
        expectedData.put("status",status);
        expectedData.put("data",data);
        expectedData.put("message",message);

        return expectedData;
    }









}
