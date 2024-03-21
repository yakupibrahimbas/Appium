package post_requests;
import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Post01 extends PetStoreBaseUrl {
    /*
        Given
            https://petstore.swagger.io/v2/pet
        And
            {
                "id": 9898,
                "category": {
                    "id": 0,
                    "name": "Köpek"
                },
                "name": "Pamuk",
                "photoUrls": [
                    "string"
                ],
                "tags": [
                    {
                        "id": 0,
                        "name": "Sibirya Kurdu"
                    }
                ],
                "status": "available"
            }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */
    @Test
    public void post01() {
        // 1. Set the URL
        spec.pathParam("first", "pet");
        // 2. Set the expected data (payload)
        // Payload: POST, PUT, PATCH gibi requestlerle birlikte göndereceğimiz body'dir.
        String payload = "{\n" +
                "    \"id\": 9898,\n" +
                "    \"category\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"Köpek\"\n" +
                "    },\n" +
                "    \"name\": \"Pamuk\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 0,\n" +
                "            \"name\": \"Sibirya Kurdu\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";
        // 3. Send the request and get the response
        // POST requestlerde body ve content-type bilgileri tanımlanmalıdır.
        given(spec)
                .body(payload)
                .when()
                .post("{first}")
                .then() // 4. Do assertion
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}