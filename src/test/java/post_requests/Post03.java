package post_requests;
import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
     */
    @Test
    public void post03() {
        // 1. Set the URL
        spec.pathParam("first", "todos");
        // 2. Set the expected data (payload)
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);
        System.out.println(payload);
        // 3. Send the request and get the response
        // Serialization: Java datalarının Json datalarına dönüştürülmesi işlemidir.
        // pom.xml içerisine eklediğimiz Jackson Databind gibi kütüphaneler, serialization işlemini otomatik gerçekleştirir.
        Response response = given(spec).body(payload).when().post("{first}");
        JsonPath json = response.jsonPath();
        // 4. Do assertion
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), json.getInt("userId"));
        assertEquals(payload.get("title"), json.getInt("title"));
        assertEquals(payload.get("completed"), json.getInt("completed"));
    }
}