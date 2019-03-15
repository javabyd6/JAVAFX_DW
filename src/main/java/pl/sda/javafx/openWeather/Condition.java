package pl.sda.javafx.openWeather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    private String text;
    private String icon;
    private Integer code;
}
