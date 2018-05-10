
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import javax.mail.internet.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * Created by aahad on 12/26/2017.
 */
public class GooglePlaceSearchAPI {

    public static ValidatableResponse response;

    public static void main(String args[]) {
        placesearch();

    }


    @Test
    public static void placesearch() {


        RestAssured.baseURI = "https://maps.googleapis.com";

        ValidatableResponse response =
                given().
                        param("location", "-33.8670522,151.1957362").
                        param("radius", "500").
                        param("key", "AIzaSyALIAFR1FqxD-v3t-YTG_aMHbe1t7gZnUM").
                        when().get("/maps/api/place/nearbysearch/json").






        then().assertThat().statusCode(200).
        and().contentType( io.restassured.http.ContentType.JSON).and().

        // body("results[0].geometry.location.lat",equalTo("-33.867591"));


        body("results[0].name",equalTo("Sydney")).and().header("Server","pablo");


        System.out.println("value");

        //  and().contentType(ContentType.JSON).and()

        System.out.println("method");
    }

}
