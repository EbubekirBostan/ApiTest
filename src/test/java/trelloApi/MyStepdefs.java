package trelloApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.TrelloApiTestData;

public class MyStepdefs {


    //token = ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC
    //apikey = 7852a988d8215fe699b78a92c8aa400b

    public RequestSpecification specification;

    TrelloApiTestData trelloApiTestData = new TrelloApiTestData();

    Response response;

    String boardID;

    JsonPath jsonPath;
    
    
    
    @Given("Kullanici Trello icin Base URL set eder {string}")
    public void kullaniciTrelloIcinBaseURLSetEder(String arg0) {
    }

    @When("Kullanici board create edebilmek icin ilgili url e post methodu ve ilgili endpointler ile request atar {string}, {string},{string},{string}")
    public void kullaniciBoardCreateEdebilmekIcinIlgiliUrlEPostMethoduVeIlgiliEndpointlerIleRequestAtar(String arg0, String arg1, String arg2, String arg3) {
    }

    @And("Kullanici board id yi alir")
    public void kullaniciBoardIdYiAlir() {
    }

    @Then("Kullanici boad un basarili bir sekilde create edildigini dogrular")
    public void kullaniciBoadUnBasariliBirSekildeCreateEdildiginiDogrular() {
    }
}
