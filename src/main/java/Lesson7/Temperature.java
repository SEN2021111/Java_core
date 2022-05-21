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

    public long getMinimum() {
        return minimum.getValueCelsius();
    }

    public long getMaximum() {
        return maximum.getValueCelsius();
    }
}
