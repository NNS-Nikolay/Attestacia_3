package helpers;

import entity.Authorization.AuthRequest;
import entity.Authorization.AuthResponse;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AuthHelper {

    public String AuthGetToken(String username, String password){

        AuthRequest authRequest = new AuthRequest(username, password);
        AuthResponse authResponse = given()
                .basePath("auth/login")
                .body(authRequest)
                .contentType(ContentType.JSON)
                .when().post()
                .as(AuthResponse.class);

        return authResponse.userToken();
    }

}
