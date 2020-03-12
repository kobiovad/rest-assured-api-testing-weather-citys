import io.restassured.response.Response;
import weatherMenu.*;

import java.util.*;


public class Utilite {

    String [] citys = new String[] {"Tel Aviv","Singapore", "Auckland","Ushuaia", "Miami", "London","Berlin", "Reykjavik", "Cape Town", "Kathmandu"};

    BaseUrl baseUrl = new BaseUrl();
    String key = "2f5a21385dfb4e9b9cadfc177e89d140";
    long min=0, max=0;
    String cityMin="",cityMax="";


    public void sendBaseURL() {
        for (int i = 0; i < citys.length; i++) {
            long between = baseUrl.getMethod(citys[i],key);
            checkMinAndMax(between,citys[i],i);
        }
        weatherFlow weatherflow = new weatherFlow();
        System.out.println("city with min: " + cityMin+" Cealsius: "+ Math.round(weatherflow.getMain().getTemp()-(273.15)));
        System.out.println("city with max: " + cityMax.toString());
    }

    public void checkMinAndMax(Long between,String city,int i){

        if(i==0){
            min=max=between;
            cityMin=cityMax=city;
        }
        if(i!=0 && between<min) {
            min = between;
            cityMin= city;
        }
        if(i!=0 &&between>max) {
            max = between;
            cityMax =city;
        }
    }




}
