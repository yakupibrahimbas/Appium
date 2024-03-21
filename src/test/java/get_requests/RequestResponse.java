package get_requests;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestResponse {
    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/5";
        Response response = given().when().get(url);
        response.prettyPrint();
        response.print();
        /*
        prettyPrint() ve print() metotları sadece response'taki body kısmını yazdırır.
            - prettyPrint() metodu body'yi satırlara ayırarak okunaklı bir şekilde yazdırır.
            - print() metodu body'yi tek satırda yazdırır.
        */
        // Status code nasıl yazdırılır?
        System.out.println("Status Code: " + response.statusCode());
        // Status Line nasıl yazdırılır?
        System.out.println("Status Line: " + response.statusLine());
        // Content-Type nasıl yazdırılır?
        System.out.println("Content Type: " + response.contentType());
        // Header bölümündeki bir başlık nasıl yazdırılır?
        System.out.println("Header | Server: " + response.header("Server"));
        // Header bölümündeki tüm başlıklar nasıl yazdırılır?
        System.out.println("Headers: \n" + response.headers());
        // Time bilgisi nasıl yazdırılır?
        System.out.println("Time: " + response.time());
    }
}