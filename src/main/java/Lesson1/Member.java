package Lesson1;

public class Member {
    public int weight, tall, age;
    public String name;

    public Member(int weight, int tall, int age, String name) {
        this.weight = weight;
        this.tall = tall;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Участник: " + name + " вес: " + weight + " рост: " + tall + " возраст: " + age;
    }
}
