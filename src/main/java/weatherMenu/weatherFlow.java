package weatherMenu;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class weatherFlow {

    coord coord;
    ArrayList<weather> weathers;
    String base;
    main main;
    Long visibility;
    wind wind;
    clouds clouds;
    Long dt;
    sys sys;
    Long timezone;
    Long id;
    String name;
    Integer cod;

    public Long dayLight(){
        return sys.getSunset()-sys.getSunrise();
    }

    @Override
    public String toString(){
        return (this.name +": "+ main.getTemp()+" Cealsius: "+Math.round(main.getTemp()-(273.15)));
    }

}

