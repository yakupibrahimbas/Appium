package utilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class AuthenticatePracticeSoftwareTesting {
    public static String generateToken(){
        String url = "https://api.practicesoftwaretesting.com/users/login";
        String body = "{\n" +
                "  \"email\": \"admin@practicesoftwaretesting.com\",\n" +
                "  \"password\": \"welcome01\"\n" +
                "}";
        Response response = given().body(body).contentType(ContentType.JSON).when().post(url);
        return response.jsonPath().getString("access_token");
    }
}