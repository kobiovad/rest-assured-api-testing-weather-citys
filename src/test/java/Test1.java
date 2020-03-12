import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import weatherMenu.weatherFlow;

import java.io.IOException;

import static io.restassured.RestAssured.UNDEFINED_PORT;
import static io.restassured.RestAssured.given;

public class Test1 {

    @Test
    public void checkSun(){
        Utilite ut =new Utilite();
        ut.sendBaseURL();
    }
    @Test
    public void checkBetweenByMaria() throws IOException {
        UtiliteByMaria ubm =new UtiliteByMaria();
            ubm.sendBaseURL();
    }

    @Test
    public void checkSun2(){

           weatherFlow weatherflow   =  given()
                    .header("Content-Type","application/json")
                .when()
                     .get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=2f5a21385dfb4e9b9cadfc177e89d140")
                .then()
                     .statusCode(200)
                     .and()
                //.log().all()
                .extract().response().as(weatherFlow.class);

        System.out.print((weatherflow.getSys().getSunset())-(weatherflow.getSys().getSunrise()));
    }



}
