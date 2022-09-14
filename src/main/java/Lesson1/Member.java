package Lesson1;

public class Member {
    private int weight, power, age;
    private String name;

    public Member(int weight, int power, int age, String name) {
        this.weight = weight;
        this.power = power;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Участник: " + name + " вес: " + weight + " сила: " + power + " возраст: " + age;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}
