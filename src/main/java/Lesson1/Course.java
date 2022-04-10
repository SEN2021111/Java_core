package Lesson1;

import java.lang.reflect.Array;

public class Course {
    String[] barier = new String[3];

    public Course() {
        this.barier[0] = ("Бег");
        this.barier[1] = ("Прыжки");
        this.barier[2] = ("Плавание");
    }

    public boolean doIt(Team team) {
        int j = 0;
        for (int i = 0; i < team.members.length; i++) {
            if (team.members[i].tall > 40) {
                j++;
            }
        }
        if (j != 4) {
            return false;
        }
        return true;
    }
}
