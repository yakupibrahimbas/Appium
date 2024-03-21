package get_requests;

import baseUrl.PetStoreBaseUrl_2;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get05_2 extends PetStoreBaseUrl_2 {
    @Test
    public void get05_2() {
        spec.pathParams("first","pet","second","findByStatus")
                .queryParam("status","available");
        given(spec).when().get("{}{}");
    }
}
