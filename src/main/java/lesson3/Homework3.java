package lesson3;

public class Homework3 {
    public static void main(String[] args) {
        String[] txtArr = {"январь", "февраль", "март", "апрель"};
        printArr(txtArr);
        swap(txtArr, 1, 2);
        printArr(txtArr);
    }

    private static void swap(String[] arr, int i, int j) {
        String s = arr[i];
        arr[i] = arr[j];
        arr[j] = s;
    }

    private static void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("----------");
    }
}
