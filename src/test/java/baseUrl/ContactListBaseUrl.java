package baseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

class ContactListBaseUrl extends PetStoreBaseUrl {

    @BeforeEach
    public void setUp() {
        spec=new RequestSpecBuilder().setBaseUri("https://thinking-tester-contact-list.herokuapp.com/").build();
    }
}

