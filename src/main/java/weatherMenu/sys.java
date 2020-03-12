package weatherMenu;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class sys {

    Integer type;
    Integer id;
    String country;
    Long sunrise;
    Long sunset;

}
