import weatherMenu.weatherFlow;

import static io.restassured.RestAssured.given;


public class BaseUrlByMaria {

    public weatherFlow getResponse(String city, String key) {

        weatherFlow weatherFlowOut = given()
                    .header("Content-Type", "application/json")
                .when()
                     .get("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key)
                .then()
                    .statusCode(200)
                    .and()
                .extract().response().as(weatherFlow.class);

        System.out.println(weatherFlowOut.getSys().getSunrise());

        return weatherFlowOut;

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



