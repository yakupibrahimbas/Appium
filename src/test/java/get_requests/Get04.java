package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/9898
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
*/

    @Test
    public void get04() {
        spec.pathParams("first","pet","second",9898);
       Response response= given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);




    }
}
