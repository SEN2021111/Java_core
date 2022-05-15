package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Extremum {

    private float value;
    private String unit;

    @JsonSetter("Value")
    private void setValue(String value) {
        this.value = Float.parseFloat(value);
    }

    @JsonSetter("Unit")
    private void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValueCelsius() {
        if(Objects.equals(unit, "F")){
            return Math.round((value - 32) * 5/9);
        }
        else {
            return value;
        }
    }

}
