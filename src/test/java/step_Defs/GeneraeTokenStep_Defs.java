package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.GenerateToken;

public class GeneraeTokenStep_Defs {

    GenerateToken generateToken=new GenerateToken();

    @Given("input valid credentials")
    public void input_valid_credentials() {
       generateToken.generateToken();

    }



    @Then("verify tokenStatusCode")
    public void verify_tokenStatusCode() {
        generateToken.verifygenerateStatusCode();
    }

}
