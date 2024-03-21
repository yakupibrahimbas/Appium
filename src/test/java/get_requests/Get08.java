package get_requests;
import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos
        When
           Kullanıcı URL'e bir GET request gönderir
        Then
           1) Status code 200 olmalı
           2) "Id"leri 190 dan büyük olanları konsola yazdırın
              "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
           3) "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
              "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
           4) "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
              "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
     */
    @Test
    public void get08() {
        // 1. Set the URL
        spec.pathParam("first", "todos");
        // 2. Set the expected data
        // 3. Send the request and get the response
        Response response = given(spec).when().get("{first}");
        JsonPath json = response.jsonPath();
        // 4. Do assertion
        assertEquals(200, response.statusCode());
//        2) "Id"leri 190 dan büyük olanları konsola yazdırın
        List<Object> jsonList = json.getList("findAll{it.id > 190}");
        System.out.println("ID'si 190'dan büyük olan datalar: \n" + jsonList);
//        "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        assertEquals(10, jsonList.size());
//        3) "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Integer> userIdList = json.getList("findAll{it.id < 5}.userId");
        System.out.println("UserID List: \n" + userIdList);
//        "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        assertEquals(4, userIdList.size());
//        4) "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<String> titleList = json.getList("findAll{it.id < 5}.title");
        System.out.println("Title List: \n" + titleList);
//        "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        assertTrue(titleList.contains("delectus aut autem"));
        // Başlık
        int id = json.getInt("find{it.title=='et doloremque nulla'}.id");
        System.out.println("ID: " + id);

    }
}