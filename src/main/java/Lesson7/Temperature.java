package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private Extremum minimum;
    private Extremum maximum;

    @JsonSetter("Minimum")
    private void setMinimum(Extremum minimum) {
        this.minimum = minimum;
    }

    @JsonSetter("Maximum")
    private void setMaximum(Extremum maximum) {
        this.maximum = maximum;
    }

    public float getMinimum() {
        return minimum.getValueCelsius();
    }

    public float getMaximum() {
        return maximum.getValueCelsius();
    }
}
