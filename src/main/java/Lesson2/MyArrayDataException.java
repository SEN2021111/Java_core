package Lesson2;

public class MyArrayDataException extends Exception {
    private static String s = "Не допустимый элемент массива ";

    public MyArrayDataException() {
        super(s);
    }
}
