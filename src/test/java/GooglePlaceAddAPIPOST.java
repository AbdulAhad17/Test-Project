import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by aahad on 12/27/2017.
 */
public class GooglePlaceAddAPIPOST {
    public static void main(String args[]) {
        addplace();
    }

    @Test
    public static void addplace() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        ValidatableResponse response;


        response =  given().
                queryParam("key", "AIzaSyALIAFR1FqxD-v3t-YTG_aMHbe1t7gZnUM").
                body("{\n" +
                        "            \"location\":{\n" +
                        "            \"lat\":-33.8669710,\n" +
                        "                    \"lng\":151.1958750\n" +
                        "        },\n" +
                        "            \"accuracy\":50,\n" +
                        "                \"name\":\"Google Shoes!\",\n" +
                        "                \"phone_number\":\"(02) 9374 4000\",\n" +
                        "                \"address\":\"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\n" +
                        "                \"types\": [\"shoe_store\"],\n" +
                        "            \"website\":\"http://www.google.com.au/\",\n" +
                        "                \"language\":\"en-AU\"}").
                when().
                post("/maps/api/place/add/json").
                then().assertThat().statusCode(200);


            System.out.println("response" + response.extract().asString());



    }
}
