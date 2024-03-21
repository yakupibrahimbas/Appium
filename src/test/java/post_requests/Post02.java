package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrl {
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
    public void post02() {
        //1.set the url
        spec.pathParam("first","todos");
        //2.set the expected data(payload)
        String payload="{\n" +
                "         \"userId\": 55,\n" +
                "         \"title\": \"Tidy your room\",\n" +
                "         \"completed\": false\n" +
                "       }";
        //3.send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
        JsonPath json=response.jsonPath();
        assertEquals(201,response.statusCode());
        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertEquals(false,json.getBoolean("completed"));


    }
}
