package Lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    private static String s = "Не допустимый размер массива";

    public MyArraySizeException() {
        super(s);
    }
}
