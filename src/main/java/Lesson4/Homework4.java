package Lesson4;

import java.util.*;

public class Homework4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октярь",
                "ноябрь", "декабрь",
                "январь",
                "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октярь",
                "ноябрь", "декабрь"
        );

        Set<String> uniList = new HashSet<>(list);

        System.out.println(uniList);

        for (String s: uniList) {
            System.out.println(s + ": " + Collections.frequency(list, s));
        }

        System.out.println("-- Задание №2 --");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("GorGaz","04");
        phoneBook.add("Petrov","3667776767");
        phoneBook.add("Petrov","1111111111");

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("GorGaz"));

        phoneBook.add("Petrov","2222222");
        System.out.println(phoneBook.get("Petrov"));
    }
}