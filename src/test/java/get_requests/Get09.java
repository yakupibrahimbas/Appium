package get_requests;
import baseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class Get09 extends PracticeSoftwareTestingBaseUrl {
    static String id;
    @Test
    public void get09GetUserList() {
        spec.pathParam("first", "users");
        Response response = given(spec).when().get("{first}");
        JsonPath json = response.jsonPath();
        response.prettyPrint();
        id = json.getString("data.find{it.email == 'customer@practicesoftwaretesting.com'}.id");
        System.out.println("ID:" + id);
    }
    @Test
    public void get09GetUser() {
        spec.pathParams("first", "users", "second", id);
        given(spec).when().get("{first}/{second}").prettyPrint();
    }
}