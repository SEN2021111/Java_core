package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayPart {
    private String phrase;

    @JsonSetter("IconPhrase")
    private void setPhrase(String iconPhrase) {
        this.phrase = iconPhrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
