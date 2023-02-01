package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.Authorized;

public class AutherizesStep_Defs {
    Authorized authorized=new Authorized();
    @Given("User should be authorized with valid credentials")
    public void user_should_be_authorized_with_valid_credentials() {

        authorized.userAuthorized();
    }



    @Then("verify authorizedStatusCode")
    public void verify_authorizedStatusCode() {
        authorized.verifyAutStatusCode();

    }


}
