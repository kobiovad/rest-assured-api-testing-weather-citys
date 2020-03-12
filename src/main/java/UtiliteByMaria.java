import weatherMenu.weatherFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class UtiliteByMaria {

    String [] citys = new String[] {"Tel Aviv","Singapore", "Auckland","Ushuaia", "Miami", "London","Berlin", "Reykjavik", "Cape Town", "Kathmandu"};

    List<weatherFlow> flowList;
    BaseUrlByMaria Blop = new BaseUrlByMaria();
    String key = "2f5a21385dfb4e9b9cadfc177e89d140";

    Comparator <weatherFlow> comparator=Comparator.comparing(weatherFlow::dayLight);

    public void checkShorterAndLongerDay() {
        weatherFlow shorter = this.shortestDaylight();
        weatherFlow longer = this.longestDayLight();
        printAnswer(shorter,longer);
    }

    public weatherFlow shortestDaylight(){
        weatherFlow shortest = flowList.stream()
                .min(comparator)
                .get();
        return shortest;
    }
    public weatherFlow longestDayLight(){
        weatherFlow longest= flowList.stream()
                .max(comparator)
                .get();
        return longest;

    }
    public void printAnswer(weatherFlow shorter,weatherFlow longer){
        System.out.println("Temperature of Shortest daylight "+shorter.toString());
        System.out.println("Temperature of Longest daylight "+longer.toString());
    }

    public void sendBaseURL() throws IOException{
        flowList = new ArrayList<>();
        for (int i = 0; i < citys.length; i++) {
            System.out.println("blop "+ citys[i]);
            weatherFlow weatherflow  = Blop.getResponse(citys[i],key);
            flowList.add(weatherflow);
        }
       checkShorterAndLongerDay();
    }
}
