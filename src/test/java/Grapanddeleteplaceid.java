import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

/**
 * Created by aahad on 12/28/2017.
 */
public class Grapanddeleteplaceid {
    public static ValidatableResponse response;

    public static void main(String args[]) {
        grapanddeleteplaceid();
        //test();
        //  value();


    }

    @Test
    public static void grapanddeleteplaceid() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        //ValidatableResponse response;


        response = given().
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
                then().body("scope", equalTo("APP"));
        //then().assertThat().statusCode(200);

        String js = response.extract().body().path("scope");
//ValidatableResponse z = js;

        System.out.println("value" + js);
//System.out.println(z);
//        String js = response.extract().body().path("place_id");
//        String c = js;
//        String as =
//
//
//        System.out.println("placeid: " + js.toString());
    }

    // System.out.println("response" + response.extract().asString());

    //public static void test() {

    //   given().
    //           queryParam("key", "AIzaSyALIAFR1FqxD-v3t-YTG_aMHbe1t7gZnUM").
    //           body("{\"Scope\": \"+delete+\"}").
    //          when().
    //         post("/maps/api/place/delete/json").
    //         then().
    //        assertThat().statusCode(200).and().contentType(ContentType.JSON);
    // System.out.println("Successgully Deleted");


    // }
    // public static void value(){
    //    String name1 = response.extract().body().path("place_id", has);
    //     System.out.println("Name1"+name1);
    //   String name2 = name1;
    //     int b;
    //    b=name2.compareTo(name1);

    //    if(b==0)
    //    {
    //        //name1 = name2;
    //        System.out.println("Pass");
    //    }
    //     else
    //    {
    //        System.out.println("Fail");
    //    }

    // System.out.println("Hello");


}
// String a = response.toString();
//System.out.println(a);
//JsonPath js= new JsonPath(a);
//String placeid=js.get("place_id");
//System.out.println(placeid);


