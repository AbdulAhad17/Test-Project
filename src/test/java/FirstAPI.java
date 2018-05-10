import io.restassured.response.Response;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by aahad on 12/21/2017.
 */

public class FirstAPI {

    public static void main(String args[]) {

        System.out.println("I am here");




    }


    public void myFirstMethod(){
        System.out.println("in my first method");
    }

    @Test
    public void myMethod(){

        Response response =
                (Response) given().
                        contentType("application/json").
                        when().
                        body("{\"username\":\"msiddiqi@nisum.com\",\"password\":\"123\"}").
                        post("http://10.4.10.108:8080/auth/login").
                        then().
                        assertThat().statusCode(200).extract().response();

        System.out.println("your way is to complete" + response.getBody().asString());

    }


}
