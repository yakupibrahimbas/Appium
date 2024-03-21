package get_requests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Get03 {
    /*
    Given
        https://petstore.swagger.io/v2/pet/9898
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        "name" şu metni içermeli: "Pamuk",
    And
        "status" değeri "available" olmalı
    And
        "category" altındaki "name" değeri "Köpek" olmalı
    And
        "tags" altındaki "name" değeri "Sibirya Kurdu" olmalı
 */

    @Test
    public void get03() {
        RestAssured.baseURI = " https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/9898";

        given().
                when().
                get().
                then().statusCode(200).contentType("application/json").body("name", containsString("Pamuk")).body("status", equalTo("available")).body("category.name", equalTo("Köpek")).body("tags[0].name", equalTo("Sibirya Kurdu"));
    }
}