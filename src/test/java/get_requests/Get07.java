package get_requests;

import baseUrl.PetStoreBaseUrl;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get07 extends PetStoreBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/23
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is "application/json"
    And
        Response body should be like;
  {
        "booking"
        "firstname": "Bradley",
        "lastname": "Pearson",
        "totalprice": 132,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2022-10-27",
            "checkout": "2022-11-07"
        },
        "additionalneeds": "None"
    }
 */

    @Test
    public void Get07() {
        spec.pathParams("frst","booking","second",594);
        given(spec).when().get("{first}/{second}").then();


    }
}
