
package get_requests;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.specification.RequestSpecification;
        import org.junit.jupiter.api.BeforeEach;
public class ContactListBaseUrl {
    protected RequestSpecification spec;
    @BeforeEach
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWYyMDNlNjAzZWYyZjAwMTM3OTRkMWEiLCJpYXQiOjE3MTA4NDQ1OTN9.dGohEQmdBynWf6bO0A8finsU1kTln_JfcvM4idoaA0U")
                .build();
    }
}
