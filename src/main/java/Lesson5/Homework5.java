package Lesson5;

import java.io.IOException;
import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) throws IOException {
        TestWriteCSV fw = new TestWriteCSV("hw5.csv");

        fw.setHeader(new String[]{"Region", "City", "Street", "House"});

        System.out.println(Arrays.toString(fw.getHeader()));

        fw.addRecord(new String[]{"Moskva","Moskva","Arbat","1"});
        fw.addRecord(new String[]{"Voronjskaya obl","Voronej","Lenina","2"});
        fw.addRecord(new String[]{"Nijegorodsaya obl","Nijniy Novgorod","Gogolya","3"});

        System.out.println(fw.getData());
        fw.save();

        System.out.println("-- Читаем из файла --");

        TestReadCSV fr = new TestReadCSV("hw5.csv");
        System.out.println(Arrays.toString(fr.getHeader()));
        System.out.println(fr.getData());
    }
}