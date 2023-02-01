package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfiguratinReader;

import java.util.HashMap;
import java.util.Map;

public class Authorized {
    Response response;

    public void userAuthorized(){
        String password= ConfiguratinReader.get("commonPassword");
        String username=ConfiguratinReader.get("username");

        Map<String,Object> body=new HashMap<>();
        body.put("userName",username);
        body.put("password",password);

        Map<String,Object>token=new HashMap<>();
        token.put("Authorization","Bearer"+ConfiguratinReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(token)
                .body(body)
                .when().log().all()
                .post("/Account/v1/Authorized");
    }

    public void verifyAutStatusCode(){
        response.then().statusCode(200);
    }

}
