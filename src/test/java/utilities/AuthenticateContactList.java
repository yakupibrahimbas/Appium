package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateContactList {

    public static String generateToken(){
        String url = "https://thinking-tester-contact-list.herokuapp.com/users/login";

        String body = "{\n" +
                "    \"email\": \"brandin.haadi@farmoaks.com\",\n" +
                "    \"password\": \"Yakup.1461\"\n" +
                "}";

        Response response = given().body(body).contentType(ContentType.JSON).when().post(url);
        return  response.jsonPath().getString("token");



    }
}