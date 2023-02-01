package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfiguratinReader;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken {
    Response response;

    public String token;

    public void generateToken(){
        /*
        {
  "userName": "string",
  "password": "string"
}
        */

        String password= ConfiguratinReader.get("commonPassword");
        String username=ConfiguratinReader.get("username");

        Map<String,Object> body=new HashMap<>();
        body.put("userName",username);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body)
                .when().log().all()
                .post("/Account/v1/GenerateToken").prettyPeek();
        token=response.path("token");
        System.out.println("token = " + token);


    }

    public void verifygenerateStatusCode(){
        response.then().statusCode(200);
    }
}
