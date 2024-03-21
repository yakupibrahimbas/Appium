package get_requests;

import baseUrl.PetStoreBaseUrl_2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get04_2 extends PetStoreBaseUrl_2 {
    @Test
    public void get04() {
        //1.Set the URL
        spec.pathParams("first","pet","second",9898);
        //2.Set the expected data

        //3.Send the request and get the response
       Response response= given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //4.Do assertion
        response.then().statusCode(200).contentType(ContentType.JSON);
    }
}
