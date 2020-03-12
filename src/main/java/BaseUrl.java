import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.regexp.internal.RE;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import weatherMenu.*;

import static io.restassured.RestAssured.*;


public class BaseUrl {

    public long getMethod(String city, String key) {

        weatherFlow weatherFlowOut = given()
                    .header("Content-Type", "application/json")
                .when()
                     .get("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key)
                .then()
                    .statusCode(200)
                    .and()
                .extract().response().as(weatherFlow.class);
       // System.out.print((weatherFlowOut.getSys().getSunset())-(weatherFlowOut.getSys().getSunrise()));

        long between = weatherFlowOut.getSys().getSunset() - weatherFlowOut.getSys().getSunrise();
        return between;

    }
}

   /* weatherFlow weatherflowInput = new weatherFlow();
    weatherFlow weatherflowOutput = new weatherFlow();
    Gson gson = new GsonBuilder().create();
    JSONObject jsonObject = new JSONObject();*/

     /*   Response response= RestAssured.

       // String data = response.asString();

             given()
                .header("Content-Type","application-json")
                .and()
                .body(jsonObject.toJSONString())
             .when()
                .get("api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key)
             .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response();

        weatherflowOutput = gson.fromJson(response.prettyPrint(),weatherFlow.class);

        return (weatherflowOutput.getSys().getSunset())- (weatherflowOutput.getSys().getSunset());*/



