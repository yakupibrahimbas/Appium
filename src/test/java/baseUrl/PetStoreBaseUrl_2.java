package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class PetStoreBaseUrl_2 {

   protected RequestSpecification spec;
    @BeforeEach
    public void setUp() {
        RequestSpecification spec=new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();
    }
}
