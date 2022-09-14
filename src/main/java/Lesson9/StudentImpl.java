package Lesson9;

import java.util.List;

public class StudentImpl implements Student {
    private String name;
    private List<Course> courseList;

    public StudentImpl(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }
}
