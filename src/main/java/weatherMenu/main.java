package weatherMenu;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class main {

    Double temp;
    Double feels_like;
    Double temp_min;
    Double temp_max;
    Integer pressure;
    Integer humidity;
}
