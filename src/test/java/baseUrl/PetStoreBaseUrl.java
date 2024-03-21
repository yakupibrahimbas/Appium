package baseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
public class PetStoreBaseUrl {
    protected RequestSpecification spec;
    @BeforeEach
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2").setContentType(ContentType.JSON)
                .build();
    }
}