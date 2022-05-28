package Lesson9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Homework9 {
    public static void main(String[] args) {

        Course c1 = new CourseImpl("c1");
        Course c2 = new CourseImpl("c2");
        Course c3 = new CourseImpl("c3");
        Course c4 = new CourseImpl("c4");
        Course c5 = new CourseImpl("c5");
        Course c6 = new CourseImpl("c6");

        Student s1 = new StudentImpl("s1", Arrays.asList(c1, c2, c3, c4));
        Student s2 = new StudentImpl("s2", Arrays.asList(c3, c4, c5));
        Student s3 = new StudentImpl("s3", Arrays.asList(c2, c1, c5, c4, c3));
        Student s4 = new StudentImpl("s4", Arrays.asList(c1, c4, c3));

        System.out.println("----#1");
        getUniqueCourse(Arrays.asList(s1, s4)).forEach(x -> System.out.println(x.toString()));
        System.out.println("----#2");
        getSmartStudent(Arrays.asList(s1, s2, s3, s4), 1).forEach(x -> System.out.println(x.getName()));
        System.out.println("----#3");
        getStudenAtCourse(Arrays.asList(s1, s2, s3, s4), c2).forEach(x -> System.out.println(x.getName()));
    }

    //Задание 1. Список уникальных курсов
    private static List<Course> getUniqueCourse(List<Student> studentList) {
        return studentList.stream().flatMap(
                        x -> x.getAllCourses().stream()).collect(Collectors.toList())
                .stream().distinct().collect(Collectors.toList());
    }

    //Задание 2. Список самых любознательных
    private static List<Student> getSmartStudent(List<Student> studentList, long limit) {
        Comparator<Student> studentComparator = Comparator.comparingInt(student -> student.getAllCourses().size());
        return studentList.stream()
                .sorted(studentComparator.reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    //Задание 3. Список студентов, которые посещают этот курс
    private static List<Student> getStudenAtCourse(List<Student> studentList, Course course) {
        return studentList.stream().filter(
                        student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
