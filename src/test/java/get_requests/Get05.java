package get_requests;
import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Get05 extends PetStoreBaseUrl {
    /*
        Given
            https://petstore.swagger.io/v2/pet/findByStatus?status=available
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Listede id değeri 9898 olan bir eleman olmalı
        And
            Listede name değeri "Pamuk" olan bir eleman olmalı
        And
            Listede name değerleri "Pamuk", "doggie", "fish" olan elemanlar olmalı
        And
            Listede en az 200 tane eleman olmalı
        And
            Listede 500'den az eleman olmalı
        And
            Listenin ilk elemanının category - id değeri 0 olmalı
        And
            Listenin ilk elemanının photoUrls değeri "string" olmalı
        And
            Listenin ilk elemanının tags - id değeri 0 olmalı
     */
    @Test
    public void get05() {
        // 1. Set the URL
        spec.pathParams("first", "pet", "second", "findByStatus")
                .queryParam("status", "available");
        // 2. Set the expected data
        // 3. Send the request and get the response
        given(spec)
                .when()
                .get("{first}/{second}")
                .then() // 4. Do assertion
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasItem(9898))
                .body("name", hasItem("Pamuk"))
                .body("name", hasItems("Pamuk", "doggie", "fish"))
                .body("id", hasSize(greaterThan(200)))
                .body("id", hasSize(lessThan(500)))
                .body("[0].category.id", equalTo(100))
                // Body'de eğer bir index'e ulaşmak istiyorsak, köşeli parantez gördüğümüz yerde köşeli parantez açıp index noyu yazmalıyız.
                // Süslü parazntez gördüğümüz yerde nokta işareti koyarak ulaşmak istediğimiz alt başlığı yazmalıyız.
                .body("[0].photoUrls[0]", equalTo("string"))
                .body("[0].tags[0].id", equalTo(0));
    }
}